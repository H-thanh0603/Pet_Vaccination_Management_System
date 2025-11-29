package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // 1. Cấu hình quyền truy cập
            .authorizeHttpRequests((requests) -> requests
                // Cho phép TẤT CẢ các request truy cập mà không cần đăng nhập
                .anyRequest().permitAll() 
            )
            
            // 2. Tắt các tính năng bảo vệ mặc định (để dev cho dễ)
            .csrf(csrf -> csrf.disable()) // Tắt chống giả mạo request
            .formLogin(form -> form.disable()) // Tắt form đăng nhập mặc định
            .logout(logout -> logout.disable()); // Tắt chức năng đăng xuất

        return http.build();
    }
}