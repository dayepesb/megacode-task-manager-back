package co.com.megacode.service.impl;

import co.com.megacode.entity.UserEntity;
import co.com.megacode.exception.MegacodeException;
import co.com.megacode.repository.UserRepository;
import co.com.megacode.service.BaseService;
import co.com.megacode.service.MailerMegacodeService;
import co.com.megacode.service.MailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;

import static co.com.megacode.enumeration.ErrorMessagesEnum.ERROR_EMAIL_NO_REGISTER;
import static co.com.megacode.enumeration.ErrorMessagesEnum.ERROR_USER_VERIFY;

@Service
public class MailerMegacodeServiceImpl extends BaseService implements MailerMegacodeService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailerService mailerService;
    @Override
    public void resendVerifyUser(String email) throws MegacodeException, IOException, MessagingException {
        UserEntity user = userRepository.findByEmail(email);

        if (user == null) {
            throw new MegacodeException(ERROR_EMAIL_NO_REGISTER);
        }

        if (user.isVerify()) {
            throw new MegacodeException(ERROR_USER_VERIFY);
        }

        mailerService.sendMailVerifyAccount(user);
    }

}
