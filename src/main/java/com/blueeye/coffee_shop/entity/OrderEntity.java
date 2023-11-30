package com.blueeye.coffee_shop.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity{
    @Column(name = "user_id")
    private Long userId;
    @ManyToMany(mappedBy = "orders")
    private List<ProductEntity> products = new ArrayList<ProductEntity>();
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "cost")
    private int cost;
    @ManyToOne
    @JoinColumn(name = "bill_id")
    private BillEntity bill;

    public OrderEntity() {
    }

    public OrderEntity(Long userId, List<ProductEntity> products, int quantity, int cost, BillEntity bill) {
        this.userId = userId;
        this.products = products;
        this.quantity = quantity;
        this.cost = cost;
        this.bill = bill;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<ProductEntity> getProduct() {
        return products;
    }

    public void setProduct(List<ProductEntity> product) {
        this.products = products;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public BillEntity getBill() {
        return bill;
    }

    public void setBill(BillEntity bill) {
        this.bill = bill;
    }
}
