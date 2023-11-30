package com.blueeye.coffee_shop.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
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
    @Column(name = "thumbnail")
    private String thumbnail;
    @ManyToOne
    @JoinColumn(name = "classify_id")
    private ClassifyEntity classify;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_order",
                joinColumns = @JoinColumn(name = "product_id"),
                inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<OrderEntity> orders = new ArrayList<OrderEntity>();

    public ProductEntity() {
    }

    public ProductEntity(String name, String description, int cost, String thumbnail, ClassifyEntity classify, List<OrderEntity> orders) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.thumbnail = thumbnail;
        this.classify = classify;
        this.orders = orders;
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

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
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
}
