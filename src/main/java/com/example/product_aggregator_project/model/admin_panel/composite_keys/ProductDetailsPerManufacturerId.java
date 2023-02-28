package com.example.product_aggregator_project.model.admin_panel.composite_keys;

import java.io.Serializable;

public class ProductDetailsPerManufacturerId implements Serializable {

    private Integer manufacturerId;

    private String manufacturerName;

    private String productName;

    public ProductDetailsPerManufacturerId() {
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
