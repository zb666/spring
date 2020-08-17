package it.cast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("accountController")
@RequestMapping("/account")
public class AccountController {

    @RequestMapping("/findAccount")
    public String findAccount(){
        return "success";
    }

}
