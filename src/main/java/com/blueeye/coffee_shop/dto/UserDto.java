package com.blueeye.coffee_shop.dto;


import java.util.List;

public class UserDto extends AbstractDto<UserDto>{
    private String name;
    private String phone;
    private String address;
    private String avatar;
    private String email;
    private String username;
    private String password;
    private List<String> roleCode;

    public UserDto() {
    }

    public UserDto(String name, String phone, String address, String avatar, String email, String username, String password, List<String> roleCode) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.avatar = avatar;
        this.email = email;
        this.username = username;
        this.password = password;
        this.roleCode = roleCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(List<String> roleCode) {
        this.roleCode = roleCode;
    }
}
