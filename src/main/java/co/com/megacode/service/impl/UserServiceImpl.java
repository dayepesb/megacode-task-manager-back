package co.com.megacode.service.impl;

import co.com.megacode.DTO.request.UserVerifyDTO;
import co.com.megacode.entity.UserEntity;
import co.com.megacode.exception.MegacodeException;
import co.com.megacode.repository.UserRepository;
import co.com.megacode.service.BaseService;
import co.com.megacode.service.MailerService;
import co.com.megacode.service.UserService;
import co.com.megacode.util.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private MailerService mailerService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public Boolean verifyUser(UserVerifyDTO userVerifyDTO) throws MegacodeException, IOException, MessagingException {

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

        if(!userOptional.get().isVerify()){
            UserEntity user = userOptional.get();
            user.setVerify(true);
            userRepository.save(user);

            mailerService.sendMailWelcomePlatform(user);
        }

        return true;
    }

    @Override
    public void verifyToken(String token) throws MegacodeException {
        try {
            if( jwtTokenUtil.isTokenExpired(token) ){
                //token expirado
                throw new MegacodeException(ERROR_TOKEN_EXPIRED);
            }

            Claims claims = jwtTokenUtil.getAllClaimsFromToken(token);
            Long id = Long.parseLong(claims.get("ID",String.class));

            if(id == null)
                throw new MegacodeException(ERROR_TOKEN_EXPIRED);

            Optional<UserEntity> userOptional = this.userRepository.findById(id);

            if(!userOptional.isPresent()) {
                throw new MegacodeException(ERROR_BAD_CREDENTIALS);
            }
            
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
    }
}
