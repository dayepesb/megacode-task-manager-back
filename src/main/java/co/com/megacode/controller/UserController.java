package co.com.megacode.controller;

import co.com.megacode.DTO.request.UserLoginRequestDTO;
import co.com.megacode.DTO.request.UserRegisterRequestDTO;
import co.com.megacode.DTO.response.UserResponseDTO;
import co.com.megacode.entity.UserEntity;
import co.com.megacode.exception.MegacodeException;
import co.com.megacode.service.UserService;
import co.com.megacode.util.JwtTokenUtil;
import co.com.megacode.util.MegacodeEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

import static co.com.megacode.constant.UrlName.*;

@RestController
@RequestMapping(value = URL_USER)
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping(value = URL_REGISTER_USER,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            headers = { "content-type=application/json" })
    public UserResponseDTO registerUser(@RequestBody(required = true) UserRegisterRequestDTO userRegisterRequestDTO) throws MegacodeException {
        return userService.registerUser(userRegisterRequestDTO);
    }

    @PostMapping(value = URL_LOGIN,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            headers = { "content-type=application/json" })
    public UserResponseDTO loginUser(@RequestBody(required = true) UserLoginRequestDTO userLoginRequestDTO) throws MegacodeException {

        UserEntity user = userService.validateUsernamePassword(userLoginRequestDTO);

        UserDetails userDetails = new User(user.getUsername(),user.getPassword(), new ArrayList<>());
        HashMap<String,String> claims = new HashMap<>();
        claims.put("ID",String.valueOf(user.getId()));

        final String token = jwtTokenUtil.generateToken(userDetails,claims);

        UserResponseDTO responseDTO = new UserResponseDTO(user,token);

        return responseDTO;
    }

}
