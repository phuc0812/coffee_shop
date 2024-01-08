package com.blueeye.coffee_shop.controller.web.user;

import com.blueeye.coffee_shop.dto.OrderDto;
import com.blueeye.coffee_shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @RequestMapping("/thong-tin-dat-ban")
    public String listOrder(@RequestParam("id") Long id, Model model){
        List<OrderDto> orders = orderService.findAllByUserId(id);
        model.addAttribute("orders", orders);
        return "web/user/listOrder";
    }

    @RequestMapping("/thong-tin-dat-ban/chi-tiet")
    public String detailOrder(@RequestParam("id") Long id, Model model){
        OrderDto orderDto = orderService.findById(id);
        model.addAttribute("order", orderDto);
        return "web/user/order";
    }
}
