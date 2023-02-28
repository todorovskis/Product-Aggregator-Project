package com.example.product_aggregator_project.model.admin_panel.dto;

import com.example.product_aggregator_project.model.admin_panel.composite_keys.ProductDetailsPerManufacturerId;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.math.BigDecimal;

@Entity(name = "product_details_per_manufacturer")
@Subselect("select * from project.product_details_per_manufacturer")
@Immutable
@IdClass(ProductDetailsPerManufacturerId.class)
public class ProductDetailsPerManufacturer {

    @Id
    private Integer  manufacturerId;

    @Id
    private String manufacturerName;

    @Id
    private String productName;

    private Integer minPrice;

    private Integer maxPrice;

    private BigDecimal avgPrice;

    public ProductDetailsPerManufacturer() {
    }

    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public void setAvgPrice(BigDecimal averagePrice) {
        this.avgPrice = averagePrice;
    }
}
