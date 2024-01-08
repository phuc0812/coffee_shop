package com.blueeye.coffee_shop.service.IService;

import com.blueeye.coffee_shop.dto.UserDto;
import com.blueeye.coffee_shop.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    UserDto save(UserDto dto);
    UserEntity findByUsername(String username);
    UserDto findByName(String username);
    UserDto findById(Long id);
}
