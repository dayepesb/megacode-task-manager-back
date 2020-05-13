package co.com.megacode.service.impl;

import co.com.megacode.DTO.request.UserLoginRequestDTO;
import co.com.megacode.DTO.request.UserRegisterRequestDTO;
import co.com.megacode.DTO.request.UserVerifyDTO;
import co.com.megacode.DTO.response.UserResponseDTO;
import co.com.megacode.entity.UserEntity;
import co.com.megacode.exception.MegacodeException;
import co.com.megacode.repository.UserRepository;
import co.com.megacode.service.BaseService;
import co.com.megacode.service.MailerService;
import co.com.megacode.service.UserService;
import co.com.megacode.util.FormatUtil;
import co.com.megacode.util.JwtTokenUtil;
import co.com.megacode.util.MegacodeEncoder;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import java.io.IOException;
import java.security.SignatureException;
import java.util.Optional;

import static co.com.megacode.enumeration.ErrorMessagesEnum.*;

@Service
@Transactional(rollbackOn = {Exception.class})
public class  UserServiceImpl extends BaseService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MegacodeEncoder encoder;

    @Autowired
    private MailerService mailerService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public UserResponseDTO registerUser(UserRegisterRequestDTO userRegisterRequestDTO) throws MegacodeException, IOException, MessagingException {

        String name = userRegisterRequestDTO.getName();
        String lastname = userRegisterRequestDTO.getLastname();
        String userName = userRegisterRequestDTO.getUsername();
        String email = userRegisterRequestDTO.getEmail();
        String password = userRegisterRequestDTO.getPassword();

        if(name==null || name.isEmpty())
            throw new MegacodeException(ERROR_NAME_EMPTY);

        if(lastname==null || lastname.isEmpty())
            throw new MegacodeException(ERROR_LASTNAME_EMPTY);

        if(userName==null || userName.isEmpty())
            throw new MegacodeException(ERROR_USERNAME_EMPTY);

        if(email==null || email.isEmpty())
            throw new MegacodeException(ERROR_EMAIL_EMPTY);

        if(!FormatUtil.validateFormatEmail(email))
            throw new MegacodeException(ERROR_EMAIL_INVALID_FORMAT);

        if(password==null || password.isEmpty())
            throw new MegacodeException(ERROR_PASSWORD_EMPTY);

        if(!FormatUtil.validateFormatPassword(password))
            throw new MegacodeException(ERROR_PASSWORD_INVALID);

        UserEntity userRegister = userRepository.findByUsername(userName);
        if(userRegister != null)
            throw new MegacodeException(ERROR_USERNAME_EXIST);

        userRegister = userRepository.findByEmail(email);
        if(userRegister != null)
            throw new MegacodeException(ERROR_EMAIL_REGISTER);

        String passwordDecryptAES = encoder.decryptAes(userRegisterRequestDTO.getPassword());
        String passwordEncode = encoder.encodingPasswordUser(passwordDecryptAES);

        UserEntity user = new UserEntity();
        user.setUsername(userName);
        user.setName(name);
        user.setLastName(lastname);
        user.setPassword(passwordEncode);
        user.setEmail(email);

        userRepository.save(user);

        this.sendEmailVerifyUser(user);

        UserResponseDTO userDTO = new UserResponseDTO();
        mapper.map(user, userDTO);

        return userDTO;
    }

    @Override
    public UserEntity validateUsernamePassword(UserLoginRequestDTO userLoginRequestDTO) throws MegacodeException, IOException, MessagingException {

        String username = userLoginRequestDTO.getUsername();

        UserEntity user = userRepository.findByUsernameOrEmail(username);

        if(user == null){
            throw new MegacodeException(ERROR_BAD_CREDENTIALS);
        }

        String passwordAes = userLoginRequestDTO.getPassword();
        String passwordDecryptAES = encoder.decryptAes(passwordAes);

        String userPassword = user.getPassword();

        if(!encoder.comparePassword(passwordDecryptAES, userPassword)){
            throw new MegacodeException(ERROR_BAD_CREDENTIALS);
        }

        if(!user.isVerify()){
            //mailerService.sendMailVerifyAccount(user);
            throw new MegacodeException(ERROR_USER_NO_ACTIVATE);
        }

        return user;
    }

    @Override
    public Boolean verifyUser(UserVerifyDTO userVerifyDTO) throws MegacodeException {

        String token = userVerifyDTO.getToken();

        try {
            jwtTokenUtil.isTokenExpired(token);
        } catch (Exception e) {
            logger.error("token Expirado");
            logger.error(e.getClass().toString());
            logger.error(e.getMessage());
            if( e.getClass() == SignatureException.class ){
                //conversion token fallido
                throw new MegacodeException(ERROR_TOKEN_CONVERSION);
            }else {
                //Token Expirado
                throw new MegacodeException(ERROR_TOKEN_EXPIRED);
            }
        }

        Claims claims = jwtTokenUtil.getAllClaimsFromToken(token);
        Long id = Long.valueOf(claims.get("ID", String.class));

        Optional<UserEntity> userOptional = userRepository.findById(id);

        if(!userOptional.isPresent()) {
            throw new MegacodeException(ERROR_BAD_CREDENTIALS);
        }

        UserEntity user = userOptional.get();
        user.setVerify(true);
        userRepository.save(user);

        return true;
    }

    @Override
    public void resendVerifyUser(String email) throws MegacodeException, IOException, MessagingException {
        UserEntity user = userRepository.findByEmail(email);

        if (user == null) {
            throw new MegacodeException(ERROR_EMAIL_NO_REGISTER);
        }

        if (user.isVerify()) {
            throw new MegacodeException(ERROR_USER_VERIFY);
        }

        this.sendEmailVerifyUser(user);
    }

    private void sendEmailVerifyUser(UserEntity user) throws IOException, MessagingException {
        mailerService.sendMailVerifyAccount(user);
    }

}
