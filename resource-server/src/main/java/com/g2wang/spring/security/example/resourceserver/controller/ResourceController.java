package com.g2wang.spring.security.example.resourceserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @GetMapping("/users")
    public String[] getUsers() {
        return new String[]{"User 1", "User 2", "User 3"};
    }
}