package com.g2wang.spring.security.example.authserver.db;

import org.springframework.security.core.GrantedAuthority;

public class CustomAuthority implements GrantedAuthority {

    @Override
    public String getAuthority() {
        return "USER";
    }
}
