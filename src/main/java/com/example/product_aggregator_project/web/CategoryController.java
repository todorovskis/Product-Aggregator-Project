package com.example.product_aggregator_project.web;

import com.example.product_aggregator_project.model.Category;
import com.example.product_aggregator_project.model.Product;
import com.example.product_aggregator_project.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String getCategoryPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Category> categories = this.categoryService.listCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("bodyContent", "listCategories");
        return "master-template";
    }

    @PostMapping
    public String filterCategoriesByInput(@RequestParam String input, Model model){
        List<Category> categories = this.categoryService.listCategoriesByInput(input);
        model.addAttribute("categories", categories);
        model.addAttribute("bodyContent", "listCategories");
        return "master-template";
    }

    @PostMapping("/{id}")
    public String getProductsInCategory(@PathVariable Integer id, Model model) {
        List<Product> products = this.categoryService.listProductsByCategory(id);
        model.addAttribute("products", products);
        model.addAttribute("bodyContent", "listProducts");
        return "master-template";
    }
}
