package com.example.product_aggregator_project.service.impl;

import com.example.product_aggregator_project.model.Category;
import com.example.product_aggregator_project.model.Manufacturer;
import com.example.product_aggregator_project.model.Product;
import com.example.product_aggregator_project.model.ProductCharacteristic;
import com.example.product_aggregator_project.model.exceptions.CategoryIdNotFoundException;
import com.example.product_aggregator_project.model.exceptions.ManufacturerIdNotFoundException;
import com.example.product_aggregator_project.model.exceptions.ProductIdNotFoundException;
import com.example.product_aggregator_project.repository.CategoryRepository;

import com.example.product_aggregator_project.repository.ManufacturerRepository;
import com.example.product_aggregator_project.repository.ProductCharacteristicRepository;
import com.example.product_aggregator_project.repository.ProductRepository;
import com.example.product_aggregator_project.service.CategoryService;
import com.example.product_aggregator_project.service.ProductService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final ProductCharacteristicRepository characteristicRepository;
    private final CategoryService categoryService;


    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryRepository categoryRepository,
                              ManufacturerRepository manufacturerRepository,
                              ProductCharacteristicRepository characteristicRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.characteristicRepository = characteristicRepository;
        this.categoryService = categoryService;
    }

    @Override
    public List<Product> listProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findById(Integer productId) {
        return this.productRepository.findById(productId)
                .orElseThrow(ProductIdNotFoundException::new);
    }

    @Override
    public Product addProduct(String productName, Integer categoryId, Integer manufacturerId, LocalDate postDate, String characteristicDesc) {
        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(CategoryIdNotFoundException::new);
        Manufacturer manufacturer = this.manufacturerRepository.findById(manufacturerId)
                .orElseThrow(ManufacturerIdNotFoundException::new);
        ProductCharacteristic characteristic = new ProductCharacteristic(characteristicDesc);
        this.characteristicRepository.save(characteristic);

        Product product = setProductProperties(productName, manufacturer, postDate, characteristic, category);

        return this.productRepository.save(product);
    }

    @Override
    public List<Product> listProductsByNameAndCategoryAndManufacturer(String name, Integer categoryId, Integer manufacturerId) {
        Category category = categoryId != null ? this.categoryRepository.findById(categoryId)
                .orElse(null) : null;
        Manufacturer manufacturer = manufacturerId != null ? this.manufacturerRepository.findById(manufacturerId)
                .orElse(null) : null;

        if (name != null && category != null && manufacturer != null) {
            return this.productRepository
                    .findAllByProductNameContainingIgnoreCaseAndCategoryEqualsAndManufacturerEquals(name, category, manufacturer);
        } else if (name != null && category != null) {
            return this.productRepository
                    .findAllByProductNameContainingIgnoreCaseAndCategoryEquals(name, category);
        } else if (name != null && manufacturer != null) {
            return this.productRepository
                    .findAllByProductNameContainingIgnoreCaseAndManufacturerEquals(name, manufacturer);
        } else if (category != null && manufacturer != null) {
            return this.productRepository
                    .findAllByCategoryEqualsAndManufacturerEquals(category, manufacturer);
        } else if (name != null) {
            return this.productRepository.findByProductNameContainingIgnoreCase(name);
        } else if (category != null) {
            List<Product> products = new ArrayList<>();
            addProducts(category, products);

            return this.productRepository.findAllByCategoryEquals(category);
            //return products.stream().distinct().collect(Collectors.toList());
        } else if (manufacturer != null) {
            return this.productRepository.findAllByManufacturerEquals(manufacturer);
        } else {
            return this.productRepository.findAll();
        }
    }

    private void addProducts(Category category, List<Product> products) {
        products.addAll(category.getProducts());
        category.getSubcategories().forEach(s -> addProducts(s, products));
    }

    private Product setProductProperties(String productName, Manufacturer manufacturer, LocalDate postDate,
                                      ProductCharacteristic characteristic, Category category){

        List<Category> allCategories = this.categoryService.findAllParentCategories(category);

        Category mainCategory = allCategories.get(allCategories.size() - 1);
        Product product = new Product(productName, mainCategory, manufacturer, postDate, characteristic);
        product.setCategory(mainCategory);
        allCategories.remove(allCategories.size() - 1);
        product.setCategories(allCategories);
        product.setManufacturer(manufacturer);
        product.setCharacteristic(characteristic);

        return product;
    }
}
