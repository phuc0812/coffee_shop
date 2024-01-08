package com.blueeye.coffee_shop.dto;

public class CartDto extends AbstractDto<CartDto>{
    private int quantity;
    private Long productId;
    private String productName;
    private int productCost;
    private String productThumbnail;
    private Long userId;

    public CartDto() {
    }

    public CartDto(int quantity, Long productId, String productName, int productCost, String productThumbnail, Long userId) {
        this.quantity = quantity;
        this.productId = productId;
        this.productName = productName;
        this.productCost = productCost;
        this.productThumbnail = productThumbnail;
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductCost() {
        return productCost;
    }

    public void setProductCost(int productCost) {
        this.productCost = productCost;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getProductThumbnail() {
        return productThumbnail;
    }

    public void setProductThumbnail(String productThumbnail) {
        this.productThumbnail = productThumbnail;
    }
}
