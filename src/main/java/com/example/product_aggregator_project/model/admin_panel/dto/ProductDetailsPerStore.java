package com.example.product_aggregator_project.model.admin_panel.dto;

import com.example.product_aggregator_project.model.admin_panel.composite_keys.ProductDetailsPerStoreId;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.math.BigDecimal;

@Entity(name = "product_details_per_store")
@Subselect("select * from  project.product_details_per_store")
@Immutable
@IdClass(ProductDetailsPerStoreId.class)
public class ProductDetailsPerStore {

    @Id
    private Integer storeId;

    @Id
    private String storeName;

    private Integer minPrice;

    private Integer maxPrice;

    private BigDecimal avgPrice;

    public ProductDetailsPerStore() {
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

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    public BigDecimal getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(BigDecimal avgPrice) {
        this.avgPrice = avgPrice;
    }
}
