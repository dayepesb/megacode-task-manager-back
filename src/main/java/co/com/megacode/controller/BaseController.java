package co.com.megacode.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class BaseController {
}
