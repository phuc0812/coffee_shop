package com.blueeye.coffee_shop.controller.web;

import com.blueeye.coffee_shop.dto.OrderDto;
import com.blueeye.coffee_shop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "homeControllerOfWeb")
public class HomeController {

    private ShopService shopService;
    private OrderService orderService;
    private UserService userService;

    @Autowired
    public HomeController(ShopService shopService, OrderService orderService, UserService userService){
        this.shopService=shopService;
        this.orderService=orderService;
        this.userService=userService;
    }

    @RequestMapping("/trang-chu")
    public String home(Model model){
        model.addAttribute("order", new OrderDto());
        return "web/home";
    }
}
