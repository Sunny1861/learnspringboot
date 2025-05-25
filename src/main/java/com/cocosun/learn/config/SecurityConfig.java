package com.cocosun.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // ✅ New syntax for disabling CSRF
                .authorizeHttpRequests(auth -> auth
                .requestMatchers("/users/**").permitAll()
                .anyRequest().authenticated()
                )
                .formLogin(withDefaults()); // Use Spring Security's default login form
        return http.build();
    }
}
