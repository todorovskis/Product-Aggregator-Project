package com.example.product_aggregator_project.model.admin_panel.composite_keys;

import java.io.Serializable;

public class ProductDetailsPerStoreId implements Serializable {

    private Integer storeId;

    private String storeName;

    public ProductDetailsPerStoreId() {
    }

    public ProductDetailsPerStoreId(Integer storeId, String storeName) {
        this.storeId = storeId;
        this.storeName = storeName;
    }
}
