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
}
