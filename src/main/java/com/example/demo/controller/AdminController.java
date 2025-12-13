package com.example.demo.controller;

import com.example.demo.service.ProductService;

import com.example.demo.service.VetServiceService;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private VetServiceService vetServiceService;

    @GetMapping
    public String dashboard(Model model) {
        model.addAttribute("userCount", userRepository.count());
        model.addAttribute("productCount", productService.getAllProducts().size());
        model.addAttribute("serviceCount", vetServiceService.getAllServices().size());
        return "admin/dashboard";
    }
}
