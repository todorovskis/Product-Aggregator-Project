package com.example.product_aggregator_project.service.impl;

import com.example.product_aggregator_project.model.Category;
import com.example.product_aggregator_project.model.Manufacturer;
import com.example.product_aggregator_project.model.Product;
import com.example.product_aggregator_project.model.exceptions.ProductIdNotFoundException;
import com.example.product_aggregator_project.repository.CategoryRepository;

import com.example.product_aggregator_project.repository.ManufacturerRepository;
import com.example.product_aggregator_project.repository.ProductRepository;
import com.example.product_aggregator_project.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ManufacturerRepository manufacturerRepository;


    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, ManufacturerRepository manufacturerRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.manufacturerRepository = manufacturerRepository;
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
    public List<Product> listProductsByNameAndCategoryAndManufacturer(String name, Integer categoryId, Integer manufacturerId) {
        Category category = categoryId != null ? this.categoryRepository.findById(categoryId)
                .orElse(null) : null;
        Manufacturer manufacturer = manufacturerId != null ? this.manufacturerRepository.findById(manufacturerId)
                .orElse(null) : null;

        if (name != null && category != null && manufacturer != null) {
            return this.productRepository
                    .findAllByProductNameContainingIgnoreCaseAndCategoriesContainingAndManufacturerEquals(name, category, manufacturer);
        } else if (name != null && category != null) {
            return this.productRepository
                    .findAllByProductNameContainingIgnoreCaseAndCategoriesContaining(name, category);
        } else if (name != null && manufacturer != null) {
            return this.productRepository
                    .findAllByProductNameContainingIgnoreCaseAndManufacturerEquals(name, manufacturer);
        } else if (category != null && manufacturer != null) {
            return this.productRepository
                    .findAllByCategoriesContainingAndManufacturerEquals(category, manufacturer);
        } else if (name != null) {
            return this.productRepository.findByProductNameContainingIgnoreCase(name);
        } else if (category != null) {
            List<Product> products = new ArrayList<>();
            addProducts(category, products);

            //return this.productRepository.findAllByCategoriesContaining(category);
            return products.stream().distinct().collect(Collectors.toList());
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
}
