package com.example.product_aggregator_project.model.admin_panel.composite_keys;

import java.io.Serializable;

public class ProductDetailsPerManufacturerId implements Serializable {

    private Integer manufacturerId;

    private String manufacturerName;

    private String productName;

    public ProductDetailsPerManufacturerId() {
    }

    public ProductDetailsPerManufacturerId(Integer manufacturerId, String manufacturerName, String productName) {
        this.manufacturerId = manufacturerId;
        this.manufacturerName = manufacturerName;
        this.productName = productName;
    }
}
