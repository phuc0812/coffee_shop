package com.blueeye.coffee_shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/dang-nhap")
    public String login(){
        return "login";
    }
}
