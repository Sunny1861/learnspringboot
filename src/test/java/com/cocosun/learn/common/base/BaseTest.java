package com.cocosun.learn.common.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public abstract class BaseTest {

    @Autowired
    protected MockMvc mockMvc;

    @Value("${jwt.cookie.name}")
    protected String cookieName;

    @Value("${jwt.redis.key.prefix}")
    protected String redisKeyPrefix;

}
