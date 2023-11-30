package com.blueeye.coffee_shop.service;

import com.blueeye.coffee_shop.entity.RoleEntity;
import com.blueeye.coffee_shop.entity.UserEntity;
import com.blueeye.coffee_shop.repository.UserRepository;
import com.blueeye.coffee_shop.service.IService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new User(user.getUsername(), user.getPassword(), rolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> rolesToAuthorities(Collection<RoleEntity> roles){
        return roles.stream().map(role->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
