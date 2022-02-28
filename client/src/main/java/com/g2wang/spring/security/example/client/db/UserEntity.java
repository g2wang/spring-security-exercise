package com.g2wang.spring.security.example.client.db;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tbl_user")
public class UserEntity {
    @Id
    private String uuid;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
}
