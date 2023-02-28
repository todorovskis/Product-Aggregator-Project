package com.example.product_aggregator_project.model.admin_panel.composite_keys;

import java.io.Serializable;

public class ProductDetailsPerStoreId implements Serializable {

    private Integer storeId;

    private String storeName;

    public ProductDetailsPerStoreId() {
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
