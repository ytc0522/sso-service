package com.xxxx.ssoservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class LoginController {




    @PostMapping("/toMain")
    public String successRedirect(){
        log.info("Login success,redirect to main page");
        return "redirect:main.html";
    }





}
