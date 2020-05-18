package co.com.megacode.service;

import co.com.megacode.exception.MegacodeException;

import javax.mail.MessagingException;
import java.io.IOException;

public interface MailerMegacodeService {

    void resendVerifyUser(String email) throws MegacodeException, IOException, MessagingException;

}
