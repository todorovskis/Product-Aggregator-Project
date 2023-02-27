package com.example.product_aggregator_project.model.admin_panel;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.*;

@Entity(name = "num_products_by_category")
@Subselect("select * from project.num_products_by_category")
@Immutable
public class ProductNumberPerCategory {

    @Id
    private Integer categoryId;

    private String categoryName;

    private Long numProducts;

    public ProductNumberPerCategory() {
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

    public Long getNumProducts() {
        return numProducts;
    }

    public void setNumProducts(Long numProducts) {
        this.numProducts = numProducts;
    }
}
