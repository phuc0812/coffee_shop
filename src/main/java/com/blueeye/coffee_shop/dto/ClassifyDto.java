package com.blueeye.coffee_shop.dto;

public class ClassifyDto extends AbstractDto<ClassifyDto>{
    private String name;
    private String code;

    public ClassifyDto() {
    }

    public ClassifyDto(String name, String code) {
        this.name = name;
        this.code = code;
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
}
