package com.blueeye.coffee_shop.dto;


import java.util.List;

public class RoleDto extends AbstractDto<RoleDto>{
    private String name;
    private List<String> usernames;

    public RoleDto() {
    }

    public RoleDto(String name, List<String> usernames) {
        this.name = name;
        this.usernames = usernames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getUsernames() {
        return usernames;
    }

    public void setUsernames(List<String> usernames) {
        this.usernames = usernames;
    }
}
