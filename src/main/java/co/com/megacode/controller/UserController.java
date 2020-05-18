package co.com.megacode.controller;

import co.com.megacode.DTO.request.UserVerifyDTO;
import co.com.megacode.exception.MegacodeException;
import co.com.megacode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;

import static co.com.megacode.constant.UrlName.*;

@RestController
@RequestMapping(value = URL_USER)
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @PostMapping(value = URL_VERIFY_USER,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            headers = { "content-type=application/json" })
    public Boolean verifyUser(@RequestBody(required = true) UserVerifyDTO userVerifyDTO) throws MegacodeException, IOException, MessagingException {
        return this.userService.verifyUser(userVerifyDTO);
    }

    @GetMapping(value = URL_VERIFY_TOKEN)
    public void verifyToken(@RequestParam("token") String token) throws MegacodeException, IOException, MessagingException {
        this.userService.verifyToken(token);
    }

}
