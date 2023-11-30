package com.blueeye.coffee_shop.service.IService;

import com.blueeye.coffee_shop.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    public UserEntity save(UserEntity user);
    UserEntity findByUsername(String username);

}
