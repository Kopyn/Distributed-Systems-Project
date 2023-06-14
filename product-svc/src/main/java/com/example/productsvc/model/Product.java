package com.example.productsvc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    private String uniqId;
    private String sku;
    private String title;
    private String description;
    private Double distPrice;
    private Double salePrice;
    private String category;
    private String categoryTree;
    private String averageProductRating;
    private String productUrl;
    private List<String> productImageUrls;
    private String brand;
    private int totalNumberReviews;
    private List<String> reviews;

    public Product(){};

    public Product(String uniqId, String sku, String title, String description, Double distPrice,
                   Double salePrice, String category, String categoryTree, String averageProductRating,
                   String productUrl, List<String> productImageUrls, String brand, int totalNumberReviews,
                   List<String> reviews) {
        this.uniqId = uniqId;
        this.sku = sku;
        this.title = title;
        this.description = description;
        this.distPrice = distPrice;
        this.salePrice = salePrice;
        this.category = category;
        this.categoryTree = categoryTree;
        this.averageProductRating = averageProductRating;
        this.productUrl = productUrl;
        this.productImageUrls = productImageUrls;
        this.brand = brand;
        this.totalNumberReviews = totalNumberReviews;
        this.reviews = reviews;
    }

    public String getUniqId() {
        return uniqId;
    }

    public void setUniqId(String uniqId) {
        this.uniqId = uniqId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDistPrice() {
        return distPrice;
    }

    public void setDistPrice(Double distPrice) {
        this.distPrice = distPrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryTree() {
        return categoryTree;
    }

    public void setCategoryTree(String categoryTree) {
        this.categoryTree = categoryTree;
    }

    public String getAverageProductRating() {
        return averageProductRating;
    }

    public void setAverageProductRating(String averageProductRating) {
        this.averageProductRating = averageProductRating;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public List<String> getProductImageUrls() {
        return productImageUrls;
    }

    public void setProductImageUrls(List<String> productImageUrls) {
        this.productImageUrls = productImageUrls;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getTotalNumberReviews() {
        return totalNumberReviews;
    }

    public void setTotalNumberReviews(int totalNumberReviews) {
        this.totalNumberReviews = totalNumberReviews;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Product{" +
                "uniqId='" + uniqId + '\'' +
                ", sku='" + sku + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", distPrice=" + distPrice +
                ", salePrice=" + salePrice +
                ", category='" + category + '\'' +
                ", categoryTree='" + categoryTree + '\'' +
                ", averageProductRating=" + averageProductRating +
                ", productUrl='" + productUrl + '\'' +
                ", productImageUrls=" + productImageUrls +
                ", brand='" + brand + '\'' +
                ", totalNumberReviews=" + totalNumberReviews +
                ", reviews=" + reviews +
                '}';
    }
}

