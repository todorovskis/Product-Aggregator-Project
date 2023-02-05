package com.example.product_aggregator_project.web;

import com.example.product_aggregator_project.model.Category;
import com.example.product_aggregator_project.model.Manufacturer;
import com.example.product_aggregator_project.model.Product;
import com.example.product_aggregator_project.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/manufacturers")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public String getManufacturerPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Manufacturer> manufacturers = this.manufacturerService.listManufacturers();
        model.addAttribute("manufacturers", manufacturers);
        model.addAttribute("bodyContent", "listManufacturers");
        return "master-template";
    }

    @PostMapping
    public String filterManufacturersByInput(@RequestParam String input, Model model){
        List<Manufacturer> manufacturers = this.manufacturerService.listManufacturersByInput(input);
        model.addAttribute("manufacturers", manufacturers);
        model.addAttribute("bodyContent", "listManufacturers");
        return "master-template";
    }

    @PostMapping("/{id}")
    public String getProductsInCategory(@PathVariable Integer id, Model model) {
        List<Product> products = this.manufacturerService.listProductsByManufacturer(id);
        model.addAttribute("products", products);
        model.addAttribute("bodyContent", "listProducts");
        return "master-template";
    }
}
