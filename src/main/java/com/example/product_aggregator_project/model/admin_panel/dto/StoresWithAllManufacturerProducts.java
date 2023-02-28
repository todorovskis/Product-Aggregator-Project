package com.example.product_aggregator_project.model.admin_panel.dto;

import com.example.product_aggregator_project.model.admin_panel.composite_keys.StoresWithAllManufacturerProductsId;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name = "all_manufacturer_products")
@Subselect("select * from project.all_manufacturer_products")
@Immutable
@IdClass(StoresWithAllManufacturerProductsId.class)
public class StoresWithAllManufacturerProducts {

    @Id
    private Integer manufacturerId;

    private String manufacturerName;

    @Id
    private String storeName;

    private Integer numProductsInStorePerManufacturer;

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

    public Integer getNumProductsInStorePerManufacturer() {
        return numProductsInStorePerManufacturer;
    }

    public void setNumProductsInStorePerManufacturer(Integer numProductsInStorePerManufacturer) {
        this.numProductsInStorePerManufacturer = numProductsInStorePerManufacturer;
    }
}
