package com.cocosun.learn.controller.web.userregistry;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserRegistryUIController {

    @GetMapping("/register")
    public String showRegisterPage() {
        return "userregistry/register"; // maps to templates/register.html
    }
}
