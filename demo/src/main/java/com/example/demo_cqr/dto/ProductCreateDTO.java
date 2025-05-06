package com.example.demo_cqr.dto;

public class ProductCreateDTO {
    private String name;
    private Double price;
    private Integer stock;
    private Double priceFabrication;
    private Long categoryId;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPriceFabrication() {
        return priceFabrication;
    }

    public void setPriceFabrication(Double priceFabrication) {
        this.priceFabrication = priceFabrication;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}