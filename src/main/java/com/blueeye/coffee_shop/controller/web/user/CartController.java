package com.blueeye.coffee_shop.controller.web.user;

import com.blueeye.coffee_shop.dto.CartDto;
import com.blueeye.coffee_shop.service.CartService;
import com.blueeye.coffee_shop.util.CartUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller(value = "cartControllerOfWeb")
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    @RequestMapping("/gio-hang")
    public String listCarts(Model model, @RequestParam(value = "id", required = false) Long id){
        if(id==null){
            return "redirect:/trang-chu";
        }
        List<CartDto> carts = cartService.findAllByUserId(id);
        model.addAttribute("carts", carts);
        model.addAttribute("totalCost", new CartUtil().getTotalCost(carts));
        return "web/user/listCarts";
    }

}
