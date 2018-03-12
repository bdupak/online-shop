package com.epam.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @GetMapping("/403")
    public ModelAndView accessDenied() {
        ModelAndView model = new ModelAndView();
        model.setViewName("403");
        return model;
    }

    @GetMapping("/error")
    public String error(Model model) {
        return "error";
    }

}
