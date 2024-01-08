package com.blueeye.coffee_shop.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "shopControllerOfWeb")
public class ShopController {
    @RequestMapping("/gioi-thieu")
    public String about(){
        return "web/shop/about";
    }
}
