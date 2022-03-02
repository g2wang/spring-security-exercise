package com.g2wang.spring.security.example.resourceserver.service;

import com.g2wang.spring.security.example.resourceserver.db.UserJpaRepository;
import com.g2wang.spring.security.example.resourceserver.model.User;
import com.g2wang.spring.security.example.resourceserver.model.UserRegister;
import com.g2wang.spring.security.example.resourceserver.model.UserUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(UserRegister userRegister) {
        User user = new User();
        user.setUsername(userRegister.username());
        user.setPassword(passwordEncoder.encode(userRegister.password()));
        return userJpaRepository.save(user);
    }

    public User getUserByUuid(String uuid) {
        return  userJpaRepository.findById(uuid).orElse(null);
    }

    public User updateUser(String uuid, UserUpdate userUpdate) {
        User exitingUser = userJpaRepository.findById(uuid).orElseThrow(
                () -> new IllegalArgumentException("no such user"));
        exitingUser.setName(userUpdate.name());
        exitingUser.setEmail(userUpdate.email());
        exitingUser.setPhone(userUpdate.phone());
        return userJpaRepository.save(exitingUser);
    }

}
