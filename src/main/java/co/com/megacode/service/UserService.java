package co.com.megacode.service;

import co.com.megacode.DTO.request.UserLoginRequestDTO;
import co.com.megacode.DTO.request.UserRegisterRequestDTO;
import co.com.megacode.DTO.response.UserResponseDTO;
import co.com.megacode.entity.UserEntity;
import co.com.megacode.exception.MegacodeException;

public interface UserService {

    UserResponseDTO registerUser(UserRegisterRequestDTO user) throws MegacodeException;

    UserEntity validateUsernamePassword(UserLoginRequestDTO userLoginRequestDTO) throws MegacodeException;

}
