package com.blueeye.coffee_shop.service.IService;

import com.blueeye.coffee_shop.dto.OrderDto;

import java.util.List;

public interface IOrderService {
    public OrderDto save(OrderDto orderDto);

    List<OrderDto> findAllByUserId(Long id);

    OrderDto findById(Long id);
}
