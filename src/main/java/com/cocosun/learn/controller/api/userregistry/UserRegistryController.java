package com.cocosun.learn.controller.api.userregistry;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cocosun.learn.mapper.userregistry.UserRegistryMapper;
import com.cocosun.learn.model.userregistry.UserEntity;

@RestController
@RequestMapping("/auth")
public class UserRegistryController {

    private final UserRegistryMapper userRegistryMapper;
    private final PasswordEncoder passwordEncoder;

    public UserRegistryController(UserRegistryMapper userRegistryMapper, PasswordEncoder passwordEncoder) {
        this.userRegistryMapper = userRegistryMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserEntity user) {
        if (user.getUsername() == null || user.getPassword() == null
                || user.getUsername().isBlank() || user.getPassword().isBlank()) {
            return ResponseEntity.badRequest().body("Username and password are required");
        }

        if (userRegistryMapper.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");

        userRegistryMapper.insertUser(user);
        return ResponseEntity.ok("User registered successfully");
    }
}
