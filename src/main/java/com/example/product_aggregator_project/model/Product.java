package com.example.product_aggregator_project.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "post_date")
    private LocalDate postDate;

    @ManyToOne
    @JoinColumn(nullable = false, name = "manufacturer_id")
    private Manufacturer manufacturer;

    @ManyToMany
    @JoinTable(
            name = "belongs_to",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    @OneToOne
    @JoinColumn(name = "characteristic_id")
    private ProductCharacteristic characteristic;

    @OneToMany(mappedBy = "product")
    private List<Rating> ratings;

    @OneToMany(mappedBy = "product")
    private List<UserComment> userComments;

    @OneToMany(mappedBy = "product")
    private List<UserFavourite> userFavourites;

    @OneToMany(mappedBy = "product")
    private List<WatchListProduct> watchListProducts;

    @OneToMany(mappedBy = "product")
    private List<ProductInstance> productInstances;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages;

    public Product() {
    }

    public Product(Integer id, String productName, LocalDate postDate, Manufacturer manufacturer, List<Category> categories, ProductCharacteristic characteristic) {
        this.id = id;
        this.productName = productName;
        this.postDate = postDate;
        this.manufacturer = manufacturer;
        this.categories = categories;
        this.characteristic = characteristic;
    }

    public Product(String productName, Category category, Manufacturer manufacturer, LocalDate postDate, ProductCharacteristic characteristic){
        this.productName = productName;

        this.manufacturer = manufacturer;
        this.postDate = postDate;
        this.characteristic = characteristic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturerId) {
        this.manufacturer = manufacturerId;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public ProductCharacteristic getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(ProductCharacteristic characteristicId) {
        this.characteristic = characteristicId;
    }

    public List<ProductInstance> getProductInstances() {
        return productInstances;
    }

    public void setProductInstances(List<ProductInstance> productInstances) {
        this.productInstances = productInstances;
    }
}
