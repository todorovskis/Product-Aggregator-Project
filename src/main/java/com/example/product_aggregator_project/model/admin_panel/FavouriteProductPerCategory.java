package com.example.product_aggregator_project.model.admin_panel;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "favourite_product_per_category")
public class FavouriteProductPerCategory {

    @Id
    private Integer categoryId;

    private String categoryName;

    private String productName;

    private Long numUsersFavourite;

    public FavouriteProductPerCategory() {
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

    public Long getNumUsersFavourite() {
        return numUsersFavourite;
    }

    public void setNumUsersFavourite(Long numUsersFavourite) {
        this.numUsersFavourite = numUsersFavourite;
    }
}
