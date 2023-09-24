package com.example.product_aggregator_project.web.restController;

import com.example.product_aggregator_project.model.Product;
import com.example.product_aggregator_project.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/products")
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.listProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productService.findById(id);
    }

    @GetMapping("/filter")
    public List<Product> listProductsByNameAndCategoryAndManufacturer(@RequestParam(required = false) String productName,
                                                               @RequestParam(required = false) Integer categoryId,
                                                               @RequestParam(required = false) Integer manufacturerId)
    {
        return this.productService.listProductsByNameAndCategoryAndManufacturer(productName, categoryId, manufacturerId);
    }
}
