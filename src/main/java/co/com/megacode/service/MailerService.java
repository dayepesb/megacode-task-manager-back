package co.com.megacode.service;

import co.com.megacode.entity.UserEntity;

import javax.mail.MessagingException;
import java.io.IOException;

public interface MailerService {

    void sendMailVerifyAccount(UserEntity user) throws IOException, MessagingException;
}
