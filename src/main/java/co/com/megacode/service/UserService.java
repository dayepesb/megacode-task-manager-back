package co.com.megacode.service;

import co.com.megacode.DTO.request.UserRequestDTO;
import co.com.megacode.exception.MegacodeException;

public interface UserService {

    Object registerUser(UserRequestDTO user) throws MegacodeException;

}
