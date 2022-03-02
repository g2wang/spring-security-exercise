package com.g2wang.spring.security.example.client.model;

public record User (
    String uuid,
    String username,
    String name,
    String email,
    String phone
) {

}