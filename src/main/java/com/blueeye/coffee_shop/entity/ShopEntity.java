package com.blueeye.coffee_shop.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "shop")
public class ShopEntity extends BaseEntity{
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "logo")
    private String logo;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "shop", fetch = FetchType.LAZY)
    private List<BillEntity> bills;

    public ShopEntity() {
    }

    public ShopEntity(String name, String phone, String address, String logo, String description, List<BillEntity> bills) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.logo = logo;
        this.description = description;
        this.bills = bills;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<BillEntity> getBills() {
        return bills;
    }

    public void setBills(List<BillEntity> bills) {
        this.bills = bills;
    }
}
