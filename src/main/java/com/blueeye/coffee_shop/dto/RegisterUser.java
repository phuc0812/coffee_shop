package com.blueeye.coffee_shop.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

public class RegisterUser {
    @NotBlank(message = "thông tin bắt buộc")
    private String name;
    private String phone;
    private String address;
    @NotBlank(message = "thông tin bắt buộc")
    @Email(message = "Email không hợp lệ")
    private String email;
    @NotBlank(message = "thông tin bắt buộc")
    private String username;
    @NotBlank(message = "thông tin bắt buộc")
    @Size(min = 8, message = "độ dài tối thiểu 8 kí tự")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[@#$%^&+=!])(?=\\S+$).*$",
            message = "mật khẩu phải chứa ít nhất 1 chữ số và 1 ký tự đặc biệt")
    private String password;
    private List<String> roleNames;
    public RegisterUser() {
    }

    public RegisterUser(String name, String phone, String address, String email, String username, String password, List<String> roleNames) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.username = username;
        this.password = password;
        this.roleNames = roleNames;
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

    public List<String> getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(List<String> roleNames) {
        this.roleNames = roleNames;
    }
}
