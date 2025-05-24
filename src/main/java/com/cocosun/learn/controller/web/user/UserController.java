package com.cocosun.learn.controller.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cocosun.learn.model.user.User;
import com.cocosun.learn.service.user.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // Show all users and create new user form
    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", service.getAllUsers());
        model.addAttribute("user", new User()); // for the form
        return "user/list"; // return templates/user/list.html
    }

    // Handle form submit
    @PostMapping
    public String createUser(@ModelAttribute User user) {
        service.createUser(user);
        return "redirect:/users";
    }

    // Delete user
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return "redirect:/users";
    }
}
