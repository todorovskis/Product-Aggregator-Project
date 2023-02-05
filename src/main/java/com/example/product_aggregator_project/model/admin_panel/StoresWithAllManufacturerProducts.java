package com.example.product_aggregator_project.model.admin_panel;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "all_manufacturer_products")
public class StoresWithAllManufacturerProducts {

    @Id
    private Integer manufacturerId;

    private String manufacturerName;

    private String storeName;

//    private Long numProductsPerManufacturer;

    private Long numProductsInStorePerManufacturer;

    public StoresWithAllManufacturerProducts() {
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

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

//    public Long getNumProductsPerManufacturer() {
//        return numProductsPerManufacturer;
//    }
//
//    public void setNumProductsPerManufacturer(Long numProductsPerManufacturer) {
//        this.numProductsPerManufacturer = numProductsPerManufacturer;
//    }

    public Long getNumProductsInStorePerManufacturer() {
        return numProductsInStorePerManufacturer;
    }

    public void setNumProductsInStorePerManufacturer(Long numProductsInStorePerManufacturer) {
        this.numProductsInStorePerManufacturer = numProductsInStorePerManufacturer;
    }
}
