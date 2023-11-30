package com.blueeye.coffee_shop.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "shopControllerOfWeb")
public class ShopController {
    @GetMapping("/gioi-thieu")
    public String about(){
        return "web/shop/about";
    }
}
