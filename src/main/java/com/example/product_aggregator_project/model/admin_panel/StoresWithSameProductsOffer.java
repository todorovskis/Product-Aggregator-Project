package com.example.product_aggregator_project.model.admin_panel;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "same_product_offer")
@Subselect("select * from project.same_product_offer")
@Immutable
public class StoresWithSameProductsOffer {

    @Id
    private Integer storeId;

    private String storeName;

    private Long numProducts;

    public StoresWithSameProductsOffer() {
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getNumProducts() {
        return numProducts;
    }

    public void setNumProducts(Long numProducts) {
        this.numProducts = numProducts;
    }
}
