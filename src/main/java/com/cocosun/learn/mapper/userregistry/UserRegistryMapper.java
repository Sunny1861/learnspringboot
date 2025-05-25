package com.cocosun.learn.mapper.userregistry;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cocosun.learn.model.userregistry.UserEntity;

@Mapper
public interface UserRegistryMapper {

    UserEntity findByUsername(@Param("username") String username);

    void insertUser(UserEntity user);
}
