package com.blueeye.coffee_shop.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "bill")
public class BillEntity extends BaseEntity{
    @Column(name = "cost")
    private int cost;
    @ManyToOne
    @JoinColumn(name = "shop_id")
    private ShopEntity shop;

    public BillEntity() {
    }

    public BillEntity(int cost, List<OrderEntity> orders, ShopEntity shop) {
        this.cost = cost;
        this.shop = shop;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public ShopEntity getShop() {
        return shop;
    }

    public void setShop(ShopEntity shop) {
        this.shop = shop;
    }
}
