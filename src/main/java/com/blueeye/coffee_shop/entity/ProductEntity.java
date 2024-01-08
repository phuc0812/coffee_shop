package com.blueeye.coffee_shop.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity{
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "cost")
    private int cost;
    @Lob
    @Column(name = "thumbnail", columnDefinition = "MEDIUMBLOB")
    private byte[] thumbnail;
    @ManyToOne
    @JoinColumn(name = "classify_id")
    private ClassifyEntity classify;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_order",
                joinColumns = @JoinColumn(name = "product_id"),
                inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<OrderEntity> orders = new ArrayList<OrderEntity>();
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<CartEntity> carts = new ArrayList<>();

    public ProductEntity() {
    }

    public ProductEntity(String name, String description, int cost, byte[] thumbnail, ClassifyEntity classify, List<OrderEntity> orders, List<CartEntity> carts) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.thumbnail = thumbnail;
        this.classify = classify;
        this.orders = orders;
        this.carts = carts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }

    public ClassifyEntity getClassify() {
        return classify;
    }

    public void setClassify(ClassifyEntity classify) {
        this.classify = classify;
    }

    public List<CartEntity> getCarts() {
        return carts;
    }

    public void setCarts(List<CartEntity> carts) {
        this.carts = carts;
    }
}
