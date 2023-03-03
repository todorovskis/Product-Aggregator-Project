package com.example.product_aggregator_project.web;

import com.example.product_aggregator_project.model.*;
import com.example.product_aggregator_project.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
        this.userService.listUsers().forEach(i -> i.getUserComments().forEach(j -> System.out.println(j.getUser() + " " + j.getUserComment())));
        model.addAttribute("bodyContent", "listUsers");
        return "master-template";
    }

    @GetMapping("/profiles/{email}")
    public String editUser(@PathVariable String email, Model model) {
//        User user = this.userService.listUsers()
//                .stream()
//                .filter(i -> i.getEmail().equals(email))
//                .collect(Collectors.toList())
//                .get(0);
        User user = this.userService.findByEmail(email);
        model.addAttribute("user", user);
        model.addAttribute("bodyContent", "editUser");
        return "master-template";
    }

    @PostMapping("/profiles/edit/{id}")
    public String saveEditedUser(@PathVariable Integer id,
                                 @RequestParam String username,
                                 @RequestParam String email) {
        this.userService.edit(id, email, username);
        return "redirect:/home";
    }
}
