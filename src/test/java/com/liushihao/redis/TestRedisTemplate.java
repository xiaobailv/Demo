package com.liushihao.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.liushihao.entity.Jd;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRedisTemplate {

    @Autowired
//    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Test
    public void test1() {
        redisTemplate.opsForValue().set("test1Key", "这里再次输入中文");
        System.out.println(redisTemplate.opsForValue().get("test1Key"));
    }

    @Test
    public void test2() throws JsonProcessingException {
        // 真实开发中, 一般使用json来传递对象
        Jd jd = new Jd("111", "刘世豪", "", "", "", "", null);
//        String jsonJd = new ObjectMapper().writeValueAsString(jd);
        redisTemplate.opsForValue().set("jd", jd);
        System.out.println(redisTemplate.opsForValue().get("jd"));
    }
}
