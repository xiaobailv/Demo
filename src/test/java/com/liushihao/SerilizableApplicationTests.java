package com.liushihao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SerilizableApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        // opsForValue 操作字符串
        // opsForList 操作list
        redisTemplate.opsForValue();
        redisTemplate.opsForList();
    }

}
