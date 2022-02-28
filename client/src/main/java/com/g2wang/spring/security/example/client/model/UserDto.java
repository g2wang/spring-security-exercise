package com.g2wang.spring.security.example.client.model;

import lombok.Data;

@Data
public class UserDto {
    private String uuid;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
}
