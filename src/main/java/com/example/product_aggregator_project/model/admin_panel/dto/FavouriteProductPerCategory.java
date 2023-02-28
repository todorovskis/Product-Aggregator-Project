package com.example.product_aggregator_project.model.admin_panel.dto;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "favourite_product_per_category")
@Subselect("select * from project.favourite_product_per_category")
@Immutable
public class FavouriteProductPerCategory {

    @Id
    private Long categoryId;

    private String categoryName;

    private String productName;

    private Integer numUsersFavourite;

    public FavouriteProductPerCategory() {
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
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

    public Integer getNumUsersFavourite() {
        return numUsersFavourite;
    }

    public void setNumUsersFavourite(Integer numUsersFavourite) {
        this.numUsersFavourite = numUsersFavourite;
    }
}
