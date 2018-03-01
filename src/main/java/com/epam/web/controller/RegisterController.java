package com.epam.web.controller;

import com.epam.database.entity.User;
import com.epam.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerUser() {
        return "registerUser";
    }

    @ModelAttribute("user")
    public User returnUser() {
        return new User();
    }

    @PostMapping("/registerUser")
    public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {
        userService.save(user);
        return "index";
    }
}
