package com.g2wang.spring.security.example.resourceserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tbl_user")
public class User {
    @Id
    private String uuid;

    private String username;

    @JsonIgnore
    private String password;

    private String name;
    private String email;
    private String phone;
}
