package com.example.demo.controller;

import com.example.demo.service.ProductService;
import com.example.demo.service.VetServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private VetServiceService vetServiceService;

    // 1. Trang chủ (http://localhost:8080/)
    @GetMapping("/")
    public String home(Model model) {
        // Lấy 4 sản phẩm mới nhất để hiển thị ở trang chủ (demo lấy tất cả rồi sublist)
        model.addAttribute("featuredProducts", productService.getAllProducts());
        model.addAttribute("services", vetServiceService.getAllServices());
        return "home"; // Trả về home.html
    }

    // 2. Trang Về chúng tôi (http://localhost:8080/about)
    @GetMapping("/about")
    public String about() {
        return "about"; // Trả về about.html
    }

    // 3. Trang Dịch vụ (http://localhost:8080/services)
    @GetMapping("/services")
    public String services(Model model) {
        model.addAttribute("services", vetServiceService.getAllServices());
        return "services"; // Trả về services.html
    }

    // 4. Trang Chi nhánh (ví dụ)
    @GetMapping("/branches")
    public String branches() {
        return "branches";
    }
}