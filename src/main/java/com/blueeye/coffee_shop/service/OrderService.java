package com.blueeye.coffee_shop.service;

import com.blueeye.coffee_shop.converter.OrderConverter;
import com.blueeye.coffee_shop.dto.OrderDto;
import com.blueeye.coffee_shop.entity.OrderEntity;
import com.blueeye.coffee_shop.entity.UserEntity;
import com.blueeye.coffee_shop.repository.OrderRepository;
import com.blueeye.coffee_shop.repository.UserRepository;
import com.blueeye.coffee_shop.service.IService.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    private OrderRepository orderRepository;
    private OrderConverter orderConverter;
    private UserRepository userRepository;

    @Autowired
    public OrderService(OrderRepository oderOrderRepository, OrderConverter orderConverter, UserRepository userRepository){
        this.orderRepository = oderOrderRepository;
        this.orderConverter = orderConverter;
        this.userRepository = userRepository;
    }

    @Override
    public OrderDto save(OrderDto orderDto) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity = orderConverter.toEntity(orderDto);
        UserEntity userEntity = userRepository.findById(orderDto.getUserId()).get();
        orderEntity.setUser(userEntity);
        return orderConverter.toDto(orderRepository.save(orderEntity));
    }

    public List<OrderDto> findAllByUserId(Long id) {
        List<OrderEntity> orderEntities = orderRepository.findByUserId(id);
        List<OrderDto> orderDtos = new ArrayList<>();
        for(OrderEntity entity : orderEntities){
            orderDtos.add(orderConverter.toDto(entity));
        }
        return orderDtos;
    }

    @Override
    public OrderDto findById(Long id) {
        return orderConverter.toDto(orderRepository.findById(id).get());
    }
}
