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
            .authorizeHttpRequests((requests) -> requests
                // Cho phép ai cũng được truy cập vào trang chủ ("/") và các file tĩnh (css, js, ảnh)
                .requestMatchers("/", "/home", "/css/**", "/js/**", "/images/**", "/webjars/**", "/video/**", "/pictures/**").permitAll()
                // Các trang khác (sau này làm admin) thì bắt buộc đăng nhập
                .anyRequest().authenticated()
            )
            .formLogin((form) -> form
                .permitAll() // Cho phép dùng form đăng nhập mặc định
            )
            .logout((logout) -> logout.permitAll());

        return http.build();
    }
}