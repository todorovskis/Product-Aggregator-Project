package com.example.product_aggregator_project.web;

import com.example.product_aggregator_project.service.AdminPanelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/panel")
public class AdminPanelController{

    private final AdminPanelService adminPanelService;

    public AdminPanelController(AdminPanelService adminPanelService) {
        this.adminPanelService = adminPanelService;
    }

    @GetMapping
    public String getAdminPanelPage(@RequestParam(required = false) String error,
                                    Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        model.addAttribute("query1", this.adminPanelService.findStoresWithAllManufacturerProducts());
        model.addAttribute("query2", this.adminPanelService.findStoresWithSameProductsOffer());
        model.addAttribute("query3", this.adminPanelService.findHighestAvgProductRatingPerCategory());
        model.addAttribute("query4", this.adminPanelService.findProductCommentsPerManufacturer());
        model.addAttribute("query5", this.adminPanelService.findFavouriteProductsPerCategory());
        model.addAttribute("query6", this.adminPanelService.findMostFavouriteProducts());
        model.addAttribute("query7", this.adminPanelService.findProductDetailsPerStore());
        model.addAttribute("query8", this.adminPanelService.findProductDetailsPerManufacturer());
        model.addAttribute("query9", this.adminPanelService.findNumProductsPerCategory());

        model.addAttribute("bodyContent", "adminPanel");
        return "master-template";
    }
}
