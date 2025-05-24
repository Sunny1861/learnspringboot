package com.cocosun.learn.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cocosun.learn.model.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
