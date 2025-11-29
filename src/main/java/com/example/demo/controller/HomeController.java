package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // 1. Trang chủ (http://localhost:8080/)
    @GetMapping("/")
    public String home() {
        return "home"; // Trả về home.html
    }

    // 2. Trang Về chúng tôi (http://localhost:8080/about)
    @GetMapping("/about")
    public String about() {
        return "about"; // Trả về about.html
    }

    // 3. Trang Dịch vụ (http://localhost:8080/services)
    @GetMapping("/services")
    public String services() {
        return "services"; // Trả về services.html
    }
    
    // 4. Trang Chi nhánh (ví dụ)
    @GetMapping("/branches")
    public String branches() {
        return "branches"; 
    }
}