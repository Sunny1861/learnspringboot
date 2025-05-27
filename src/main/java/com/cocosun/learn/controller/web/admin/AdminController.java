package com.cocosun.learn.controller.web.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cocosun.learn.service.redis.RedisService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/active-users")
    public String getActiveUsers(Model model) {
        HashMap<String, String> map = redisService.getAllKeys();
        List<String> users = new ArrayList<>(map.keySet());
        model.addAttribute("users", users);
        return "admin/activeUsers"; // Thymeleaf page
    }

    @PostMapping("/delete-user")
    public String deleteUser(@RequestParam String username) {
        redisService.blacklistToken(username);
        return "redirect:/admin/active-users";
    }
}
