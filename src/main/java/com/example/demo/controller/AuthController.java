package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String confirmPassword,
            Model model) {
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Mật khẩu không khớp!");
            return "register";
        }

        try {
            userService.registerUser(username, email, password);
            return "redirect:/login?success";
        } catch (Exception e) {
            model.addAttribute("error", "Đăng ký thất bại: " + e.getMessage());
            return "register";
        }
    }
}
