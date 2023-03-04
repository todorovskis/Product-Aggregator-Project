package com.example.product_aggregator_project.web;

import com.example.product_aggregator_project.model.Product;
import com.example.product_aggregator_project.model.User;
import com.example.product_aggregator_project.model.UserFavourite;
import com.example.product_aggregator_project.model.exceptions.ProductIdNotFoundException;
import com.example.product_aggregator_project.model.exceptions.UserIdNotFoundException;
import com.example.product_aggregator_project.service.ProductService;
import com.example.product_aggregator_project.service.UserFavouriteService;
import com.example.product_aggregator_project.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/userfavourites")
public class UserFavouriteController {

    private final UserFavouriteService userFavouriteService;
    private final UserService userService;
    private final ProductService productService;

    public UserFavouriteController(UserFavouriteService userFavouriteService,
                                   UserService userService,
                                   ProductService productService) {
        this.userFavouriteService = userFavouriteService;
        this.userService = userService;
        this.productService = productService;
    }

    @PostMapping("/{id}")
    public String addProductToUserFavourite(@PathVariable Integer id,
                                            Authentication authentication) {

        String email = authentication.getName();
        User user = this.userService.findByEmail(email);
        Product product = this.productService.findById(id);

        this.userFavouriteService.addProductToUserFavourites(user.getId(), product.getId());

        return "redirect:/products";
    }

}
