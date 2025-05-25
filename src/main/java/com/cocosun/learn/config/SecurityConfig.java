package com.cocosun.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.cocosun.learn.service.userregistry.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                .requestMatchers("/users/**").permitAll()
                .requestMatchers("/test/**").permitAll()
                .requestMatchers("/auth/register").permitAll()
                .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder builder
                = http.getSharedObject(AuthenticationManagerBuilder.class);

        builder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());

        return builder.build(); // ✅ No `.and()` needed
    }

    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //     http
    //             .csrf(csrf -> csrf.disable()) // ✅ New syntax for disabling CSRF
    //             .authorizeHttpRequests(auth -> auth
    //             .requestMatchers("/users/**").permitAll()
    //             .requestMatchers("/test/**").hasRole("ADMIN")
    //             .anyRequest().authenticated()
    //             )
    //             .formLogin(withDefaults()); // Use Spring Security's default login form
    //     return http.build();
    // }
    // @Bean
    // public UserDetailsService userDetailsService() {
    //     UserDetails admin = User.builder()
    //             .username("admin")
    //             .password(passwordEncoder().encode("admin123"))
    //             .roles("ADMIN")
    //             .build();
    //     UserDetails user = User.builder()
    //             .username("user")
    //             .password(passwordEncoder().encode("user123"))
    //             .roles("USER")
    //             .build();
    //     return new InMemoryUserDetailsManager(admin, user);
    // }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
