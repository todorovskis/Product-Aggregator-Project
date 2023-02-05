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
    private Manufacturer manufacturerId;

    @ManyToMany
    @JoinTable(
            name = "belongs_to",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )

    private List<Category> categories;

    @OneToOne
    @JoinColumn(name = "characteristic_id")
    private ProductCharacteristic characteristicId;

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

    public Product(Integer id, String productName, LocalDate postDate, Manufacturer manufacturerId, List<Category> categories, ProductCharacteristic characteristicId) {
        this.id = id;
        this.productName = productName;
        this.postDate = postDate;
        this.manufacturerId = manufacturerId;
        this.categories = categories;
        this.characteristicId = characteristicId;
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

    public Manufacturer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Manufacturer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public ProductCharacteristic getCharacteristicId() {
        return characteristicId;
    }

    public void setCharacteristicId(ProductCharacteristic characteristicId) {
        this.characteristicId = characteristicId;
    }
}
