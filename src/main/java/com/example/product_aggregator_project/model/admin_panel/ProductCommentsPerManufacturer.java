package com.example.product_aggregator_project.model.admin_panel;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity(name = "product_comments_per_manufacturer")
public class ProductCommentsPerManufacturer {

    @Id
    private Integer manufacturerId;

    private String manufacturerName;

    private String productName;

    private Long numComments;

    private BigDecimal avgRating;

    public ProductCommentsPerManufacturer() {
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

    public Long getNumComments() {
        return numComments;
    }

    public void setNumComments(Long numComments) {
        this.numComments = numComments;
    }

    public BigDecimal getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(BigDecimal avgRating) {
        this.avgRating = avgRating;
    }
}
