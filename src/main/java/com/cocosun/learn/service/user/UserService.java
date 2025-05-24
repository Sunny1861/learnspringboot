package com.cocosun.learn.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cocosun.learn.model.user.User;
import com.cocosun.learn.repository.user.UserRepository;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return repository.findById(id);
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
