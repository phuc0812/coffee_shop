package com.blueeye.coffee_shop.rest.web.user;

import com.blueeye.coffee_shop.dto.UserDto;
import com.blueeye.coffee_shop.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRest {
    private UserService userService;

    @Autowired
    public UserRest(UserService userService){
        this.userService = userService;
    }

    @PutMapping("/api/user/thong-tin")
    public UserDto updateUser(@RequestBody UserDto userDto){
        UserDto user = userService.findById(userDto.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setRoleNames(user.getRoleNames());
        return userService.save(userDto);
    }
}
