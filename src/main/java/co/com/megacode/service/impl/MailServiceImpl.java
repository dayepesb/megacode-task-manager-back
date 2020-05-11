package co.com.megacode.service.impl;

import co.com.megacode.DTO.response.MailDTO;
import co.com.megacode.entity.UserEntity;
import co.com.megacode.service.BaseService;
import co.com.megacode.service.MailerService;
import co.com.megacode.util.JwtTokenUtil;
import co.com.megacode.util.MailerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.HashMap;

@Service
public class MailServiceImpl extends BaseService implements MailerService {

    @Value("${megacode.url.server.verify}")
    private String nameServer;

    @Autowired
    private MailerUtil mailer;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public void sendMailVerifyAccount(UserEntity user) throws IOException, MessagingException {
        try {
            HashMap<String,String> claims = new HashMap<>();
            claims.put("ID",String.valueOf(user.getId()));
            String token = jwtTokenUtil.generateToken(claims);

            MailDTO mail = new MailDTO();
            mail.setTo(user.getEmail());
            mail.setSubject("Confirm Megacode Account");
            mail.setNameTemplate("confirm-register");

            HashMap<String, String> model = new HashMap();
            model.put("name", user.getName()+" "+user.getLastName());
            model.put("url", nameServer+token);

            mail.setModel(model);

            mailer.sendTemplateThymeleafMessage(mail);
        } catch (MessagingException | IOException e) {
            System.out.println(e);
            logger.error(e.getMessage());
            throw e;
        }
    }
}
