package com.blueeye.coffee_shop.converter;

import com.blueeye.coffee_shop.dto.ProductDto;
import com.blueeye.coffee_shop.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public ProductEntity toEntity(ProductDto dto, ProductEntity entity){
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setCost(dto.getCost());
        return entity;
    }

    public ProductDto toDto(ProductEntity entity){
        ProductDto dto = new ProductDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCost(entity.getCost());
        dto.setDescription(entity.getDescription());
        dto.setClassifyId(entity.getClassify().getId());
        return dto;
    }

    public ProductEntity toEntity(ProductDto dto){
        ProductEntity entity = new ProductEntity();
        entity.setName(dto.getName());
        entity.setCost(dto.getCost());
        entity.setDescription(dto.getDescription());
        return entity;
    }

}