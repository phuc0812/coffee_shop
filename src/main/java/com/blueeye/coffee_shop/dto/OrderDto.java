package com.blueeye.coffee_shop.dto;

public class OrderDto extends AbstractDto<OrderDto>{
    private Long userId;
    private String firstName;
    private String lastName;
    private String date;
    private String time;
    private String phone;
    private String message;

    public OrderDto() {
    }

    public OrderDto(Long userId, String firstName, String lastName, String date, String time, String phone, String message) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.time = time;
        this.phone = phone;
        this.message = message;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
