package co.com.megacode.controller;

import co.com.megacode.DTO.request.UserRequestDTO;
import co.com.megacode.exception.MegacodeException;
import co.com.megacode.service.UserService;
import co.com.megacode.util.UrlName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = UrlName.URL_USER)
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = UrlName.URL_REGISTER_USER,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            headers = { "content-type=application/json" })
    public Object registerUser(@RequestBody(required = true) UserRequestDTO userRequestDTO) throws MegacodeException {
        return userService.registerUser(userRequestDTO);
    }

    @PostMapping(value = "/login")
    public Object loginUser(@RequestParam("user")String user,@RequestParam("password")String password){
        return "";
    }

}
