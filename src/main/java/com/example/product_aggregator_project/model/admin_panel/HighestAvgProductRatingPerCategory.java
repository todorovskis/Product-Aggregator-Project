package com.example.product_aggregator_project.model.admin_panel;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity(name = "highest_avg_product_rating_per_category")
public class HighestAvgProductRatingPerCategory {

    @Id
    private Integer categoryId;

    private String categoryName;

    private String productName;

    private BigDecimal avgRating;

    public HighestAvgProductRatingPerCategory() {
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(BigDecimal avgRating) {
        this.avgRating = avgRating;
    }
}
