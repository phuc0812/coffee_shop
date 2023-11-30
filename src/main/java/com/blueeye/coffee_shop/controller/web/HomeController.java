package com.blueeye.coffee_shop.controller.web;

import com.blueeye.coffee_shop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "homeControllerOfWeb")
public class HomeController {

    private ShopService shopService;
    private OrderService orderService;
    private UserService userService;

    public HomeController(ShopService shopService, OrderService orderService, UserService userService){
        this.shopService=shopService;
        this.orderService=orderService;
        this.userService=userService;
    }

    @GetMapping("/trang-chu")
    public String home(Model model){
        return "web/home";
    }
}
