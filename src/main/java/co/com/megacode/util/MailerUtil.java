package co.com.megacode.util;

import co.com.megacode.DTO.response.MailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Component
public class MailerUtil {

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;


    public void sendTemplateThymeleafMessage(MailDTO mail) throws MessagingException, IOException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Context context = new Context();

        for (Map.Entry<String, String> entry : mail.getModel().entrySet()) {
            context.setVariable(entry.getKey(),entry.getValue());
        }

        String html = templateEngine.process(mail.getNameTemplate(), context);

        helper.setTo(mail.getTo());
        helper.setSubject(mail.getSubject());

        helper.setText(html, true);
        ClassPathResource res;
        try {
            res = new ClassPathResource("/static/img/logo-lg.png");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return;
        }
        helper.addInline("logo", res);

        emailSender.send(message);
    }
}
