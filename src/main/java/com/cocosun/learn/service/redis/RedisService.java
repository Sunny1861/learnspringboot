package com.cocosun.learn.service.redis;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private final String keyPrefix;
    private final long ttlMillis;

    public RedisService(
            StringRedisTemplate redisTemplate,
            @Value("${jwt.redis.key.prefix}") String keyPrefix,
            @Value("${jwt.redis.ttl}") long ttlMillis
    ) {
        this.redisTemplate = redisTemplate;
        this.keyPrefix = keyPrefix;
        this.ttlMillis = ttlMillis;
    }

    public void saveToken(String token, String username, String ipAddress) {
        redisTemplate.opsForValue().set(keyPrefix + token + ":" + ipAddress, "valid", ttlMillis, TimeUnit.MILLISECONDS);
    }

    public boolean isTokenValid(String token) {
        String val = redisTemplate.opsForValue().get(token);
        return val != null && val.equals("valid");
    }

    public void blacklistToken(String token) {
        // Optionally store token with "blacklisted" or just delete
        redisTemplate.delete(token);
    }
}
