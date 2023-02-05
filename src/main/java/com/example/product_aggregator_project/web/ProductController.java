package com.example.product_aggregator_project.web;

import com.example.product_aggregator_project.model.Product;
import com.example.product_aggregator_project.model.ProductCharacteristic;
import com.example.product_aggregator_project.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final ManufacturerService manufacturerService;
    private final StoreService storeService;

    public ProductController(ProductService productService,
                             CategoryService categoryService,
                             ManufacturerService manufacturerService,
                             StoreService storeService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.manufacturerService = manufacturerService;
        this.storeService = storeService;
    }

    @GetMapping
    public String getProducts(@RequestParam(required = false) String error, Model model) {

        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("products", this.productService.listProducts());
        model.addAttribute("categories", this.categoryService.listCategories());
        model.addAttribute("stores", this.storeService.listStores());
        model.addAttribute("manufacturers", this.manufacturerService.listManufacturers());
        model.addAttribute("bodyContent", "listProducts");
        return "master-template";
    }

    @PostMapping
    public String listProductsByNameAndCategoryAndManufacturer(@RequestParam(required = false) String productName,
                                                               @RequestParam(required = false) Integer categoryId,
                                                               @RequestParam(required = false) Integer manufacturerId,
                                                               Model model) {
        List<Product> products = this.productService
                .listProductsByNameAndCategoryAndManufacturer(productName, categoryId, manufacturerId);
        model.addAttribute("products", products);
        model.addAttribute("categories", this.categoryService.listCategories());
        model.addAttribute("stores", this.storeService.listStores());
        model.addAttribute("manufacturers", this.manufacturerService.listManufacturers());
        model.addAttribute("bodyContent", "listProducts");
        return "master-template";
    }

    @PostMapping("/{id}")
    public String getProductInfo(@PathVariable Integer id, Model model){
        Product product = this.productService.findById(id);
        model.addAttribute("product", product);
        model.addAttribute("bodyContent", "productInfo");
        return "master-template";
    }
}
