package com.g2wang.spring.security.example.client.controller;

import com.g2wang.spring.security.example.client.model.User;
import com.g2wang.spring.security.example.client.model.UserLogin;
import com.g2wang.spring.security.example.client.model.UserRegister;
import com.g2wang.spring.security.example.client.model.UserUpdate;
import com.g2wang.spring.security.example.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Optional;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient;

@RestController
public class ClientController {

    @Autowired
    UserService userService;

    @Autowired
    private WebClient webClient;

    @GetMapping("/api/users/{uuid}")
    public ResponseEntity<User> getUserByUuid(@RegisteredOAuth2AuthorizedClient("gw-client-authorization-code")
            OAuth2AuthorizedClient authorizedClient, @PathVariable String uuid) {
        User user = this.webClient
                .get()
                .uri("http://127.0.0.1:8090/api/users/" +
                        URLEncoder.encode(uuid, Charset.forName("UTF-8")))
                .attributes(oauth2AuthorizedClient(authorizedClient))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(User.class)
                .block();
        Optional<User> body = (user == null? Optional.empty() : Optional.of(user));
        return ResponseEntity.of(body);
    }

    @PostMapping("/api/users/{uuid}")
    public ResponseEntity<User> updateUserByUuid(
            @RegisteredOAuth2AuthorizedClient("gw-client-authorization-code")
                    OAuth2AuthorizedClient authorizedClient,
            @PathVariable String uuid, @RequestBody UserUpdate userUpdate) {

        User user = this.webClient
                .post()
                .uri("http://127.0.0.1:8090/api/users/" +
                        URLEncoder.encode(uuid, Charset.forName("UTF-8")))
                .attributes(oauth2AuthorizedClient(authorizedClient))
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(userUpdate)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(User.class)
                .block();

        Optional<User> body = (user == null? Optional.empty() : Optional.of(user));
        return ResponseEntity.of(body);
    }

    @PostMapping("/api/register")
    public  ResponseEntity<User> register(@RequestBody UserRegister userRegister) {
        User user = userService.register(userRegister);
        Optional<User> body = (user == null? Optional.empty() : Optional.of(user));
        return ResponseEntity.of(body);
    }

    /**
     * get accessing token from authorization server
     * @param userLogin
     * @return
     */
    @PostMapping("/api/login")
    public String login(UserLogin userLogin) {

        // first get authorization code from authorization server
        ResponseEntity<Void> responseEntity = this.webClient
                .post()
                .uri("http://127.0.0.1:9000/login/")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .bodyValue(userLogin)
                .accept(MediaType.TEXT_PLAIN)
                .retrieve()
                .toBodilessEntity()
                .block();

        HttpHeaders headers = responseEntity.getHeaders();
        String locationHeader = headers.get("Location").get(0);
        String authCode = locationHeader.substring(locationHeader.indexOf("?") + 1);

        // then get access token using the authorization code
        return this.webClient
                .post()
                .uri("http://127.0.0.1:9000/token/")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .bodyValue("code=" + authCode)
                .accept(MediaType.TEXT_PLAIN)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}
