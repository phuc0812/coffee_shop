package com.blueeye.coffee_shop.converter;

import com.blueeye.coffee_shop.dto.UserDto;
import com.blueeye.coffee_shop.entity.RoleEntity;
import com.blueeye.coffee_shop.entity.UserEntity;
import com.blueeye.coffee_shop.util.ThumbnailUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class UserConverter{
    ThumbnailUtil thumbnailUtil = new ThumbnailUtil();
    public UserEntity toEntity(UserDto dto){
        UserEntity entity = new UserEntity();
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setUsername(dto.getUsername());
        entity.setPhone(dto.getPhone());
        if(dto.getAvatar()!=null){
            entity.setAvatar(thumbnailUtil.toByteArray(dto.getAvatar()));
        }
        return entity;
    }

    public UserDto toDto(UserEntity entity){
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setUsername(entity.getUsername());
        dto.setPhone(entity.getPhone());
        if(entity.getAvatar()!=null){
            dto.setAvatar(thumbnailUtil.toString(entity.getAvatar()));
        }
        Collection<RoleEntity> roles = entity.getRoles();
        List<String> roleNames = new ArrayList<>();
        for(RoleEntity role : roles){
            roleNames.add(role.getName());
        }
        dto.setRoleNames(roleNames);
        return dto;
    }

    public UserEntity toEntity(UserDto dto, UserEntity oldEntity){
        oldEntity.setName(dto.getName());
        oldEntity.setPhone(dto.getPhone());
        oldEntity.setEmail(dto.getEmail());
        oldEntity.setAddress(dto.getAddress());
        oldEntity.setUsername(dto.getUsername());
        oldEntity.setPassword(dto.getPassword());
        if(dto.getAvatar()!=null){
            oldEntity.setAvatar(thumbnailUtil.toByteArray(dto.getAvatar()));
        }
        return oldEntity;
    }
}
