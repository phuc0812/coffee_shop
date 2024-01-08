package com.blueeye.coffee_shop.rest.web.user;

import com.blueeye.coffee_shop.dto.OrderDto;
import com.blueeye.coffee_shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRest {
    private OrderService orderService;

    @Autowired
    public OrderRest (OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/api/dat-ban")
    public OrderDto addOrder(@RequestBody OrderDto orderDto){
        return orderService.save(orderDto);
    }
}
