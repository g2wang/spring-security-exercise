package com.g2wang.spring.security.example.resourceserver.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ResourceController {

    @GetMapping("/api/users/{uuid}")
    public String[] getUserByUuid(@PathVariable String uuid) {
        return new String[]{"User 1", "User 2", "User 3"};
    }

    @PostMapping("/api/users")
    public UserDto createUsers(@RequestBody UserDto userDto ) {
        return new String[]{"User 1", "User 2", "User 3"};
    }
}