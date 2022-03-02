package com.g2wang.spring.security.example.resourceserver.model;

public record UserUpdate (
    String name,
    String email,
    String phone
) {

}
