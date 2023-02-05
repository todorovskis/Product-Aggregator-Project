package com.example.product_aggregator_project.web;

import com.example.product_aggregator_project.model.Category;
import com.example.product_aggregator_project.model.Product;
import com.example.product_aggregator_project.service.CategoryService;
import com.example.product_aggregator_project.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String getProducts(@RequestParam(required = false) String error,
                              Model model) {

        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("products", this.productService.listProducts());
        model.addAttribute("categories", this.categoryService.listCategories());
        model.addAttribute("bodyContent", "listProducts");
        return "master-template";
    }

    @PostMapping
    public String listProductsByNameAndCategory(@RequestParam(required = false) String productName,
                                                @RequestParam(required = false) Integer categoryId,
                                                Model model) {
        List<Product> products = this.productService.findProductsByNameAndCategory(productName, categoryId);
        model.addAttribute("products", products);
        model.addAttribute("categories", this.categoryService.listCategories());
        model.addAttribute("bodyContent", "listProducts");
        return "master-template";
    }
}
