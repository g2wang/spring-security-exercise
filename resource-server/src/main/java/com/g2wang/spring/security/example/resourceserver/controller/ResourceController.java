package com.g2wang.spring.security.example.resourceserver.controller;

import com.g2wang.spring.security.example.resourceserver.model.User;
import com.g2wang.spring.security.example.resourceserver.model.UserRegister;
import com.g2wang.spring.security.example.resourceserver.model.UserUpdate;
import com.g2wang.spring.security.example.resourceserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResourceController {

    @Autowired
    UserService userService;

    @GetMapping("/api/users/{uuid}")
    public User getUserByUuid(@PathVariable String uuid) {
        return userService.getUserByUuid(uuid);
    }

    @PostMapping("/api/register")
    public User register(@RequestBody UserRegister userRegister) {
        return userService.register(userRegister);
    }

    @PostMapping("/api/users/{uuid}")
    public User updateUserByUuid(@PathVariable String uuid, @RequestBody UserUpdate userUpdate) {
        return userService.updateUser(uuid, userUpdate);
    }
}