package com.blueeye.coffee_shop.converter;

import com.blueeye.coffee_shop.dto.CartDto;
import com.blueeye.coffee_shop.entity.CartEntity;
import com.blueeye.coffee_shop.util.ThumbnailUtil;
import org.springframework.stereotype.Component;

@Component
public class CartConverter {
    public CartEntity toEntity(CartDto dto){
        CartEntity entity = new CartEntity();
        entity.setQuantity(dto.getQuantity());
        return entity;
    }

    public CartDto toDto(CartEntity entity){
        CartDto dto = new CartDto();
        dto.setQuantity(entity.getQuantity());
        dto.setId(entity.getId());
        dto.setProductName(entity.getProduct().getName());
        dto.setProductId(entity.getProduct().getId());
        dto.setProductCost(entity.getProduct().getCost());
        if(entity.getProduct().getThumbnail()!=null){
            dto.setProductThumbnail(new ThumbnailUtil().toString(entity.getProduct().getThumbnail()));
        }
        dto.setUserId(entity.getUser().getId());
        return dto;
    }
}
