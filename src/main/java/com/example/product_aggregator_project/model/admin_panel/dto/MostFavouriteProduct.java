package com.example.product_aggregator_project.model.admin_panel.dto;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "most_favourite_product")
@Subselect("select * from project.most_favourite_product")
@Immutable
public class MostFavouriteProduct {

    @Id
    private Integer productId;

    private String productName;

    private Long numUsersFavourite;

    public MostFavouriteProduct() {

    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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
