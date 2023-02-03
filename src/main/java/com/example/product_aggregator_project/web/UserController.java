package com.example.product_aggregator_project.web;

import com.example.product_aggregator_project.model.*;
import com.example.product_aggregator_project.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUsers(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        this.userService.listUsers().forEach(i-> i.getUserComments().forEach(j->System.out.println(j.getUser() +" "+ j.getUserComment())));
//                ().forEach(i -> i.getProducts().forEach(j -> System.out.println(j.getProductName() + " " + j.getManufacturerId())));
//        model.addAttribute("roles", roles);
        return "listUsers";
    }
}
