package com.blueeye.coffee_shop.service;

import com.blueeye.coffee_shop.converter.UserConverter;
import com.blueeye.coffee_shop.dto.MyUser;
import com.blueeye.coffee_shop.dto.UserDto;
import com.blueeye.coffee_shop.entity.RoleEntity;
import com.blueeye.coffee_shop.entity.UserEntity;
import com.blueeye.coffee_shop.repository.CartRepository;
import com.blueeye.coffee_shop.repository.RoleRepository;
import com.blueeye.coffee_shop.repository.UserRepository;
import com.blueeye.coffee_shop.service.IService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private CartRepository cartRepository;
    private UserConverter userConverter;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, UserConverter userConverter, CartRepository cartRepository){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userConverter = userConverter;
        this.cartRepository = cartRepository;
    }

    @Override
    public UserDto save(UserDto dto) {
        List<String> roleNames = dto.getRoleNames();
        List<RoleEntity> roles = new ArrayList<>();
        UserEntity entity = new UserEntity();
        for(String roleName : roleNames){
            RoleEntity role = roleRepository.findByName(roleName);
            roles.add(role);
        }
        if(dto.getId()!=null){
            UserEntity oldEntity = userRepository.findById(dto.getId()).get();
            oldEntity.setRoles(roles);
            entity = userConverter.toEntity(dto, oldEntity);
        }else{
            entity = userConverter.toEntity(dto);
            entity.setRoles(roles);
        }
        return userConverter.toDto(userRepository.save(entity));
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDto findByName(String username) {
        UserEntity entity = userRepository.findByUsername(username);
        if(entity==null){
            return null;
        }
        return userConverter.toDto(entity);
    }

    @Override
    public UserDto findById(Long id) {
        return userConverter.toDto(userRepository.findById(id).get());
    }

    @Override
    public MyUser loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("Invalid username or password");
        }
        MyUser myUser = new MyUser(user.getUsername(), user.getPassword(), rolesToAuthorities(user.getRoles()));
        myUser.setName(user.getName());
        myUser.setId(user.getId());
        myUser.setSizeCart(cartRepository.findAllByUserID(user.getId()).size());
        return myUser;
    }

    private Collection<? extends GrantedAuthority> rolesToAuthorities(Collection<RoleEntity> roles){
        return roles.stream().map(role->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
