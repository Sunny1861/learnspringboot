package com.cocosun.learn.service.userregistry;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cocosun.learn.mapper.userregistry.UserRegistryMapper;
import com.cocosun.learn.model.userregistry.UserEntity;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRegistryMapper userRegistryMapper;

    public CustomUserDetailsService(UserRegistryMapper userRegistryMapper) {
        this.userRegistryMapper = userRegistryMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRegistryMapper.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword()) // Must be BCrypt encoded!
                .roles(user.getRole()) // role field should not include "ROLE_"
                .build();
    }
}
