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
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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
        return this.productRepository.findAll(Sort.by(Sort.Direction.DESC, "postDate"));
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
        product.getCategories().add(category);
        product.getCategories().forEach(c -> c.getProducts().add(product));

        return this.productRepository.save(product);
    }

    @Override
    public List<Product> listProductsByNameAndCategoryAndManufacturer(String name, Integer categoryId, Integer manufacturerId) {
        Category category = categoryId != null ? this.categoryRepository.findById(categoryId)
                .orElse(null) : null;
        Manufacturer manufacturer = manufacturerId != null ? this.manufacturerRepository.findById(manufacturerId)
                .orElse(null) : null;

        return filterProducts(name, category, manufacturer);
    }

    private List<Product> filterProducts(String name, Category category, Manufacturer manufacturer) {
        List<Product> products = new ArrayList<>();

        if (!name.isEmpty() && category != null && manufacturer != null) {
            if (category.getParentCategory() == null)
                return this.productRepository
                        .findAllByProductNameContainingIgnoreCaseAndCategoryEqualsAndManufacturerEquals(name, category, manufacturer);
            else
                return this.categoryService.listProductsByCategory(category.getId());
        } else if (!name.isEmpty() && category != null) {
            if (category.getParentCategory() == null)
                return this.productRepository
                        .findAllByProductNameContainingIgnoreCaseAndCategoryEquals(name, category);
            else {
                products.addAll(this.categoryService.listProductsByCategory(category.getId()));
                return products.stream().
                        filter(p -> p.getProductName().toLowerCase()
                                .contains(name.toLowerCase())).collect(Collectors.toList());
            }
        } else if (!name.isEmpty() && manufacturer != null) {
            return this.productRepository
                    .findAllByProductNameContainingIgnoreCaseAndManufacturerEquals(name, manufacturer);
        } else if (category != null && manufacturer != null) {
            if (category.getParentCategory() == null)
                return this.productRepository
                        .findAllByCategoryEqualsAndManufacturerEquals(category, manufacturer);
            else {
                products.addAll(this.categoryService.listProductsByCategory(category.getId()));
                return products.stream().
                        filter(p -> p.getManufacturer().equals(manufacturer))
                        .collect(Collectors.toList());
            }

        } else if (!name.isEmpty()) {
            return this.productRepository.findByProductNameContainingIgnoreCase(name);
        } else if (category != null) {
            if (category.getParentCategory() == null)
                return this.productRepository.findAllByCategoryEquals(category);
            else {
                return this.categoryService.listProductsByCategory(category.getId());
            }
        } else if (manufacturer != null) {
            return this.productRepository.findAllByManufacturerEquals(manufacturer);
        } else {
            return this.productRepository.findAll(Sort.by(Sort.Direction.DESC, "postDate"));
        }
    }

    private Product setProductProperties(String productName, Manufacturer manufacturer, LocalDate postDate,
                                         ProductCharacteristic characteristic, Category category) {

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
