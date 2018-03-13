package com.epam.web.controller;

import com.epam.database.entity.Product;
import com.epam.database.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/showProducts")
    public String showProduct(Model model) {
        model.addAttribute("products", productService.getAll());
        return "showProduct";
    }

    @ModelAttribute("product")
    public Product returnProduct() {
        return new Product();
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("product") @Valid Product product, BindingResult result, Model model) {
        System.out.println(product.toString());
        System.out.println(result.hasErrors());
        System.out.println(result.getAllErrors());
        if (result.hasErrors()) {
            model.addAttribute("products", productService.getAll());
            return "showProduct";
        }
        System.out.println(product.toString());
        productService.save(product);
        return "redirect:/";
    }
}
