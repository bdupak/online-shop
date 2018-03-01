package com.epam.web.controller;

import com.epam.database.entity.User;
import com.epam.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginUser(Model model) {
        return "loginUser";
    }

    @ModelAttribute("user")
    public User returnUser() {
        return new User();
    }

    @PostMapping("/loginUser")
    public String verifyUser() {
        return "index";
    }
}
