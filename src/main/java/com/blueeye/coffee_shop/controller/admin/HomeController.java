package com.blueeye.coffee_shop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {
    @GetMapping("/quan-tri/trang-chu")
    public String home(){
        return "admin/home";
    }

}
