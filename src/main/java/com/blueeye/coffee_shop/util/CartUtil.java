package com.blueeye.coffee_shop.util;

import com.blueeye.coffee_shop.dto.CartDto;

import java.util.List;

public class CartUtil {
    public int getTotalCost(List<CartDto> carts){
        int totalCost = 0;
        for(CartDto c : carts){
            totalCost += c.getProductCost()*c.getQuantity();
        }
        return totalCost;
    }
}
