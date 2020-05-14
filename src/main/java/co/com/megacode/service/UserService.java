package co.com.megacode.service;

import co.com.megacode.DTO.request.UserLoginRequestDTO;
import co.com.megacode.DTO.request.UserRegisterRequestDTO;
import co.com.megacode.DTO.request.UserVerifyDTO;
import co.com.megacode.DTO.response.UserResponseDTO;
import co.com.megacode.entity.UserEntity;
import co.com.megacode.exception.MegacodeException;

import javax.mail.MessagingException;
import java.io.IOException;

public interface UserService {

    UserResponseDTO registerUser(UserRegisterRequestDTO user) throws MegacodeException, IOException, MessagingException;

    UserEntity validateUsernamePassword(UserLoginRequestDTO userLoginRequestDTO) throws MegacodeException, IOException, MessagingException;

    Boolean verifyUser(UserVerifyDTO userVerifyDTO) throws MegacodeException, IOException, MessagingException;

    void resendVerifyUser(String email) throws MegacodeException, IOException, MessagingException;

    void verifyToken(String token) throws MegacodeException;
}
