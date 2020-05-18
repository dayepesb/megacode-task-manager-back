package co.com.megacode.controller;

import co.com.megacode.exception.MegacodeException;
import co.com.megacode.service.MailerMegacodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;

import static co.com.megacode.constant.UrlName.*;

@RestController
@RequestMapping(value = URL_MAILER)
public class MailerController extends BaseController {

    @Autowired
    private MailerMegacodeService mailerMegacodeService;

    @GetMapping(value = URL_RESEND_VERIFY_USER)
    public void resendMailVerifyUser(@RequestParam("email") String email) throws MegacodeException, IOException, MessagingException {
        this.mailerMegacodeService.resendVerifyUser(email);
    }

    @GetMapping(value = URL_SEND_MAIL_FORGOT)
    public void sendMailForgotUser(@RequestParam("email") String email) throws MegacodeException, IOException, MessagingException {

    }
}
