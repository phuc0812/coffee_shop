package com.blueeye.coffee_shop.service;

import com.blueeye.coffee_shop.entity.OrderEntity;
import com.blueeye.coffee_shop.repository.OrderRepository;
import com.blueeye.coffee_shop.service.IService.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository oderOrderRepository){
        this.orderRepository = oderOrderRepository;
    }

    @Override
    public OrderEntity save(OrderEntity order) {
        return orderRepository.save(order);
    }
}
