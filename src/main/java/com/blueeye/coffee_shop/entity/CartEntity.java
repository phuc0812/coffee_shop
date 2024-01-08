package com.blueeye.coffee_shop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class CartEntity extends BaseEntity{
    @Column(name = "quantity")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public CartEntity() {
    }

    public CartEntity(int quantity, ProductEntity product, UserEntity user) {
        this.quantity = quantity;
        this.product = product;
        this.user = user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
