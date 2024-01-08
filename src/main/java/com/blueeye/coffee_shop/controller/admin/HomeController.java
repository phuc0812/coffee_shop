package com.blueeye.coffee_shop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {
    @RequestMapping("/quan-tri/trang-chu")
    public String home(){
        return "admin/home";
    }

}
