package com.blueeye.coffee_shop.converter;

import com.blueeye.coffee_shop.dto.OrderDto;
import com.blueeye.coffee_shop.entity.OrderEntity;
import com.blueeye.coffee_shop.util.TimeUtil;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class OrderConverter {
    private TimeUtil timeUtil = new TimeUtil();

    public OrderEntity toEntity(OrderDto dto){
        OrderEntity entity = new OrderEntity();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setDate(timeUtil.stringToDate(dto.getDate()));
        entity.setTime(timeUtil.stringToTime(dto.getTime()));
        entity.setPhone(dto.getPhone());
        entity.setMessage(dto.getMessage());
        return entity;
    }

    public OrderDto toDto(OrderEntity entity){
        OrderDto dto = new OrderDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setDate(timeUtil.dateToString(entity.getDate()));
        dto.setTime(timeUtil.timeToString(entity.getTime()));
        dto.setPhone(entity.getPhone());
        dto.setMessage(entity.getMessage());
        dto.setUserId(entity.getUser().getId());
        return dto;
    }
}
