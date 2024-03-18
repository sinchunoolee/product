package com.example.Product.dto;

public class ProductDTO {
    private String productName;
    private int pId;
    private int productPrice;
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getProductCategory() {
        return pId;
    }
    public void setProductCategory(int productCategory) {
        this.pId = productCategory;
    }
    public int getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
}
