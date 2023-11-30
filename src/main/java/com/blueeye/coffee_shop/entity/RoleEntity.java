package com.blueeye.coffee_shop.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntity{
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> users = new ArrayList<UserEntity>();

    public RoleEntity() {
    }

    public RoleEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
