package co.com.megacode.service.impl;

import co.com.megacode.DTO.request.UserRequestDTO;
import co.com.megacode.entity.UserEntity;
import co.com.megacode.exception.MegacodeException;
import co.com.megacode.repository.UserRepository;
import co.com.megacode.service.UserService;
import co.com.megacode.util.FormatUtil;
import co.com.megacode.util.MegacodeEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static co.com.megacode.enumeration.ErrorMessagesEnum.ERROR_NAME_EMPTY;
import static co.com.megacode.enumeration.ErrorMessagesEnum.ERROR_LASTNAME_EMPTY;
import static co.com.megacode.enumeration.ErrorMessagesEnum.ERROR_USERNAME_EMPTY;
import static co.com.megacode.enumeration.ErrorMessagesEnum.ERROR_EMAIL_EMPTY;
import static co.com.megacode.enumeration.ErrorMessagesEnum.ERROR_EMAIL_INVALID_FORMAT;
import static co.com.megacode.enumeration.ErrorMessagesEnum.ERROR_PASSWORD_EMPTY;
import static co.com.megacode.enumeration.ErrorMessagesEnum.ERROR_PASSWORD_INVALID;
import static co.com.megacode.enumeration.ErrorMessagesEnum.ERROR_USERNAME_EXIST;
import static co.com.megacode.enumeration.ErrorMessagesEnum.ERROR_EMAIL_REGISTER;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Object registerUser(UserRequestDTO userRequestDTO) throws MegacodeException{

        String name = userRequestDTO.getName();
        String lastname = userRequestDTO.getLastname();
        String userName = userRequestDTO.getUsername();
        String email = userRequestDTO.getEmail();
        String password = userRequestDTO.getPassword();

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

        String salt = MegacodeEncoder.generateSalt();
        String passwordDecryptAES = MegacodeEncoder.decryptAes(userRequestDTO.getPassword());
        String passwordEncode = MegacodeEncoder.encodingPasswordUser(passwordDecryptAES, salt);

        UserEntity user = new UserEntity();
        user.setUsername(userName);
        user.setName(name);
        user.setLastName(lastname);
        user.setSalt(salt);
        user.setPassword(passwordEncode);
        user.setEmail(email);

        userRepository.save(user);

        return user;
    }
}
