package com.blueeye.coffee_shop.entity;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity{
    @ManyToMany(mappedBy = "orders")
    private List<ProductEntity> products = new ArrayList<ProductEntity>();
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "date")
    private Date date;
    @Column(name = "time")
    private Time time;
    @Column(name = "phone")
    private String phone;
    @Column(name = "message")
    private String message;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public OrderEntity() {
    }

    public OrderEntity(List<ProductEntity> products, String firstName, String lastName, Date date, Time time, String phone, String message, UserEntity user) {
        this.products = products;
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.time = time;
        this.phone = phone;
        this.message = message;
        this.user = user;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
