package com.g2wang.spring.security.example.client.service;

import com.g2wang.spring.security.example.client.feign.UserFeign;
import com.g2wang.spring.security.example.client.model.User;
import com.g2wang.spring.security.example.client.model.UserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserFeign userFeign;

    public User register(UserRegister userRegister) {
        return userFeign.register(userRegister);
    }

}
