package com.blueeye.coffee_shop.converter;

import com.blueeye.coffee_shop.dto.RoleDto;
import com.blueeye.coffee_shop.entity.RoleEntity;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {
    public RoleEntity toEntity(RoleDto dto){
        RoleEntity entity = new RoleEntity();
        entity.setName(dto.getName());
        return entity;
    }

    public RoleDto toDto(RoleEntity entity){
        RoleDto dto = new RoleDto();
        dto.setName(entity.getName());
        return dto;
    }
}
