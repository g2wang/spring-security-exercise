package com.g2wang.spring.security.example.client.feign;

import com.g2wang.spring.security.example.client.model.User;
import com.g2wang.spring.security.example.client.model.UserRegister;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "userFeign", url = "http://127.0.0.1:8090")
public interface UserFeign {

    @PostMapping(value="/api/register",
            consumes = "application/json", produces = "application/json")
    User register(@RequestBody UserRegister userRegister);

}
