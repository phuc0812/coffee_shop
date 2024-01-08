package com.blueeye.coffee_shop.controller.web.user;

import com.blueeye.coffee_shop.dto.UserDto;
import com.blueeye.coffee_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InformationController {

    private UserService userService;

    @Autowired
    public InformationController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("/thong-tin/chinh-sua")
    public String editInfor(Model model, @RequestParam("id") Long id){
        UserDto user = userService.findById(id);
        model.addAttribute("user", user);
        return "web/user/information";
    }
}
