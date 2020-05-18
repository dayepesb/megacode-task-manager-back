package co.com.megacode.service;

import co.com.megacode.DTO.request.UserVerifyDTO;
import co.com.megacode.exception.MegacodeException;

import javax.mail.MessagingException;
import java.io.IOException;

public interface UserService {

    Boolean verifyUser(UserVerifyDTO userVerifyDTO) throws MegacodeException, IOException, MessagingException;

    void verifyToken(String token) throws MegacodeException;
}
