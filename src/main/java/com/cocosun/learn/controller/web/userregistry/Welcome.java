package com.cocosun.learn.controller.web.userregistry;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import com.cocosun.learn.config.JwtUtil;

@Controller
public class Welcome {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/welcome")
    public String welcomePage(HttpServletRequest request, Model model) {
        String jwt = null;
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if ("AUTH-TOKEN".equals(cookie.getName())) {
                    jwt = cookie.getValue();
                    break;
                }
            }
        }
        if (jwt != null && jwtUtil.isTokenValid(jwt, jwtUtil.extractUsername(jwt))) {
            String username = jwtUtil.extractUsername(jwt);
            model.addAttribute("username", username);
        } else {
            model.addAttribute("username", "Guest");
        }

        return "user/welcome";
    }

}
