package com.blueeye.coffee_shop.rest.web;

import com.blueeye.coffee_shop.dto.CartDto;
import com.blueeye.coffee_shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartRest{
    private CartService cartService;

    @Autowired
    public CartRest(CartService cartService){
        this.cartService = cartService;
    }

    @PostMapping("/api/gio-hang")
    public CartDto addCarts(@RequestBody CartDto cartDto){
        if(cartDto.getQuantity() == 0){
            return null;
        }
        return cartService.save(cartDto);
    }

    @DeleteMapping("/api/gio-hang")
    public void deleteCarts(@RequestBody Long id){
        cartService.delete(id);
    }
}
