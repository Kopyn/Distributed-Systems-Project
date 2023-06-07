package com.example.catalogsvc.model;

//uniq_id,sku,name_title,description,list_price,sale_price,category,category_tree,average_product_rating,
// product_url,product_image_urls,brand,total_number_reviews,Reviews
//b6c0b6bea69c722939585baeac73c13d,pp5006380337,Alfred Dunner® Essential Pull On Capri Pant,
// "You'll return to our Alfred Dunner pull-on capris again and again when you want an updated,
// casual look and all the comfort you love.   elastic waistband approx.
// 19-21"" inseam slash pockets polyester washable imported      ",41.09,24.16,alfred dunner,
// jcpenney|women|alfred dunner,4.7 out of 5,
// http://www.jcpenney.com/alfred-dunner-essential-pull-on-capri-pant/prod.jump?ppId=pp5006380337&catId=cat1002110079&&_dyncharset=UTF-8&urlState=/women/shop-brands/alfred-dunner/yellow/_/N-gkmp33Z132/cat.jump,
// "http://s7d9.scene7.com/is/image/JCPenney/DP1228201517142050M.tif?hei=380&amp;wid=380&op_usm=.4,.8,0,0&resmode=sharp2&op_usm=1.5,.8,0,0&resmode=sharp",
// Alfred Dunner,12,
// "{""review""=>[{""review_1""=>""You never have to worry about the fit...Alfred Dunner clothing sizes are true to size and fits perfectly. Great value for the money.""},
// {""review_2""=>""Good quality fabric. Perfect fit. Washed very well no iron.""}, {""review_3""=>""I do not normally wear pants or capris that have an elastic waist, but I decided to try these since they were on sale and I loved the color. I was very surprised at how comfortable they are and wear really well even wearing all day. I will buy this style again!""}, {""review_4""=>""I love these capris! They fit true to size and are so comfortable to wear. I am planning to order more of them.""}, {""review_5""=>""This product is very comfortable and the fabric launders very well""}, {""review_6""=>""I did not like the fabric. It is 100% polyester I thought it was different.I bought one at the store apprx two monts ago, and I thought it was just like it""}, {""review_7""=>""What a great deal. Beautiful Pants. Its more than I expected.""}, {""review_8""=>""Alfred Dunner has great pants, good fit and very comfortable""}]}"

import java.util.List;

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
