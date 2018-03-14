package com.epam.web.controller;

import com.epam.database.entity.User;
import com.epam.database.service.UserService;
import com.epam.utils.SaltUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Autowired
    BCryptPasswordEncoder encoder;

    @GetMapping("/register")
    public String registerUser() {
        return "registerUser";
    }

    @ModelAttribute("user")
    public User returnUser() {
        return new User();
    }

    @PostMapping("/registerUser")
    public String saveUser(@ModelAttribute("user") User user, BindingResult result, Model model) {
        user.setSalt(SaltUtil.generateSalt());
        user.setPassword(encoder.encode(user.getPassword() + user.getSalt()));
        userService.save(user);
        return "index";
    }
}
