package com.cocosun.learn.service.redis;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // @Autowired
    // private RedisTemplate<String, Object> redisTemplate1RedisTemplate;
    private final String keyPrefix;
    private final long ttlMillis;

    public RedisService(
            RedisTemplate<String, Object> redisTemplate,
            @Value("${jwt.redis.key.prefix}") String keyPrefix,
            @Value("${jwt.redis.ttl}") long ttlMillis
    ) {
        this.redisTemplate = redisTemplate;
        this.keyPrefix = keyPrefix;
        this.ttlMillis = ttlMillis;
    }

    public void saveToken(String token, String username) {
        String redisKey = keyPrefix + username;
        redisTemplate.opsForValue().set(redisKey, token, ttlMillis, TimeUnit.MILLISECONDS);
    }

    public boolean isTokenValid(String token, String username) {
        String redisKey = keyPrefix + username;
        Set<String> resSet = redisTemplate.keys(redisKey);

        if (resSet.isEmpty() || resSet.size() != 1) {
            System.err.println("Expected Only one key found, but null key found or more than one keys found:" + resSet);
            return false;
        }

        String onlyKey = resSet.iterator().next();
        Object val_o = redisTemplate.opsForValue().get(onlyKey);
        String val = String.valueOf(val_o);
        return val != null && val.equals(token);
    }

    public void blacklistToken(String redisKey) {
        // Optionally store token with "blacklisted" or just delete
        redisTemplate.delete(redisKey);
    }

    public HashMap<String, String> getAllKeys() {
        HashMap<String, String> users = new HashMap<>();
        Set<String> keys = redisTemplate.keys(keyPrefix + "*");
        if (keys != null) {
            for (String key : keys) {
                Object val_o = redisTemplate.opsForValue().get(key);
                String val = String.valueOf(val_o);
                users.put(key, val);
            }
        }
        return users;
    }
}
