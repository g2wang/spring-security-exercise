package com.g2wang.spring.security.example.resourceserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class ResourceServerConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.mvcMatcher("/users/**")
          .authorizeRequests()
          .mvcMatchers("/users/**")
          .access("hasAuthority('SCOPE_users.read')")
          .and()
          .oauth2ResourceServer()
          .jwt();
        return http.build();
    }
}