package com.blueeye.coffee_shop.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "classify")
public class ClassifyEntity extends BaseEntity{
    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;
    @OneToMany(mappedBy = "classify", fetch = FetchType.LAZY)
    private List<ProductEntity> products = new ArrayList<ProductEntity>();

    public ClassifyEntity() {
    }

    public ClassifyEntity(String name, String code, List<ProductEntity> products) {
        this.name = name;
        this.code = code;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }
}
