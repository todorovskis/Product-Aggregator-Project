package com.example.product_aggregator_project.model.admin_panel;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "all_manufacturer_products")
@Subselect("select * from project.all_manufacturer_products")
@Immutable
public class StoresWithAllManufacturerProducts {

    @Id
    private Long manufacturerId;

    private String manufacturerName;

    private String storeName;

    private Integer numProductsInStorePerManufacturer;

    public StoresWithAllManufacturerProducts() {
    }

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
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

    public Integer getNumProductsInStorePerManufacturer() {
        return numProductsInStorePerManufacturer;
    }

    public void setNumProductsInStorePerManufacturer(Integer numProductsInStorePerManufacturer) {
        this.numProductsInStorePerManufacturer = numProductsInStorePerManufacturer;
    }
}
