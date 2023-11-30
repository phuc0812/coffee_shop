package com.blueeye.coffee_shop.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "blogControllerOfWeb")
public class BlogController {
    @GetMapping("/bai-viet")
    public String listBlog(){
        return "web/blog/list";
    }
}
