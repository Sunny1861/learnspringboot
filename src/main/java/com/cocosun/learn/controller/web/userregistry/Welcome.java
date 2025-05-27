package com.cocosun.learn.controller.web.userregistry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cocosun.learn.config.JwtUtil;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class Welcome {

    @Autowired
    private JwtUtil jwtUtil;

    @Value("${jwt.cookie.name}")
    private String cookieName;

    @GetMapping("/welcome")
    public String welcomePage(HttpServletRequest request, Model model) {
        String jwt = null;
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookieName.equals(cookie.getName())) {
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
