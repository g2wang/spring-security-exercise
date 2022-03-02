package com.g2wang.spring.security.example.client.model;

public record UserUpdate (
    String name,
    String email,
    String phone
) {

}
