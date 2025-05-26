package com.cocosun.learn.controller.web.userregistry;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.cocosun.learn.dto.login.LoginRequest;
import com.cocosun.learn.dto.login.LoginResponse;

@Controller
public class AuthUIController {

    @GetMapping("/register")
    public String showRegisterPage() {
        return "userregistry/register"; // maps to templates/userregistry/register.html
    }

    @GetMapping("/login")
    public String showLogin() {
        return "user/login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
            @RequestParam String password,
            Model model) {
        RestTemplate restTemplate = new RestTemplate();
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(username);
        loginRequest.setPassword(password);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<LoginRequest> entity = new HttpEntity<>(loginRequest, headers);
        ResponseEntity<LoginResponse> response = restTemplate.postForEntity(
                "http://localhost:9090/api/auth/login", entity, LoginResponse.class);

        LoginResponse res = response.getBody();
        model.addAttribute("message", res.getMessage());
        if (res.isSuccess()) {
            model.addAttribute("token", res.getToken());
        }
        return "user/login";
    }

    @GetMapping("/welcome")
    public String welcomePage() {
        return "welcome"; // after login success
    }
}
