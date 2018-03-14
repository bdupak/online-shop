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
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    private String homePage(Model model) {
        return "index";
    }

    @GetMapping("/editUsers")
    public String userForm(Model model) {
        model.addAttribute("users", clearPasswordAndSalt(userService.getAll()));
        return "editUsers";
    }

    @ModelAttribute("user")
    public User returnUser() {
        return new User();
    }

    @PostMapping("/addUser")
    public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("users", userService.getAll());
            return "editUsers";
        }
        userService.save(user);
        return "redirect:/";
    }

    private List<User> clearPasswordAndSalt(List<User> users) {
        List<User> userList = new ArrayList<>();
        for (User user : users) {
            user.setPassword(null);
            user.setSalt(null);
            userList.add(user);
        }
        return userList;
    }
}
