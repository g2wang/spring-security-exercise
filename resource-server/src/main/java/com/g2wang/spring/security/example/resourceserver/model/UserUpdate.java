package com.g2wang.spring.security.example.resourceserver.model;

import org.springframework.validation.annotation.Validated;

@Validated
public record UserUpdate (
    String name,
    String email,
    String phone
) {

}
