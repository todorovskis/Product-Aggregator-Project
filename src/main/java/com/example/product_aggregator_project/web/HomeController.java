package com.example.product_aggregator_project.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String getHomePage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        return "homePage";
    }

    @GetMapping("/manufacturers")
    public String getManufacturersPage(Model model){
        return "redirect:/manufacturers";
    }

    @GetMapping("/categories")
    public String getCategoriesPage(Model model){
        return "redirect:/categories";
    }

    @GetMapping("/products")
    public String getProductPage(Model model){
        return "redirect:/products";
    }
}
