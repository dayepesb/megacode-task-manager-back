package co.com.megacode.service;

import co.com.megacode.DTO.request.UserLoginRequestDTO;
import co.com.megacode.DTO.request.UserRegisterRequestDTO;
import co.com.megacode.DTO.response.UserResponseDTO;
import co.com.megacode.entity.UserEntity;
import co.com.megacode.exception.MegacodeException;

import javax.mail.MessagingException;
import java.io.IOException;

public interface AuthenticationService {

    UserResponseDTO registerUser(UserRegisterRequestDTO user) throws MegacodeException, IOException, MessagingException;

    UserEntity validateUsernamePassword(UserLoginRequestDTO userLoginRequestDTO) throws MegacodeException, IOException, MessagingException;

}
