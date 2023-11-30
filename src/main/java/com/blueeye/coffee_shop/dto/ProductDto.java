package com.blueeye.coffee_shop.dto;

public class ProductDto extends AbstractDto<ProductDto>{
    private String name;
    private String description;
    private int cost;
    private String thumbnail;
    private Long classifyId;

    public ProductDto() {
    }

    public ProductDto(String name, String description, int cost, String thumbnail, Long classifyId) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.thumbnail = thumbnail;
        this.classifyId = classifyId;
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

    public Long getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Long classifyId) {
        this.classifyId = classifyId;
    }
}
