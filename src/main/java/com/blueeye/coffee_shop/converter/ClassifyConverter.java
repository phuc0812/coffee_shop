package com.blueeye.coffee_shop.converter;

import com.blueeye.coffee_shop.dto.ClassifyDto;
import com.blueeye.coffee_shop.entity.ClassifyEntity;
import org.springframework.stereotype.Component;

@Component
public class ClassifyConverter {
    public ClassifyEntity toEntity(ClassifyDto dto){
        ClassifyEntity entity = new ClassifyEntity();
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        return entity;
    }

    public ClassifyDto toDto(ClassifyEntity entity){
        ClassifyDto dto = new ClassifyDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        return dto;
    }
}
