package com.blueeye.coffee_shop.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class MyUser extends User {
    private Long id;
    private String name;
    private int sizeCart;
    public MyUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getSizeCart() {
        return this.sizeCart;
    }

    public void setSizeCart(int sizeCart) {
        this.sizeCart = sizeCart;
    }
}
