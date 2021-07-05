package com.liushihao.redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;

@Configuration
public class RedisConfig {

    /*@Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        // 创建redisTemplate对象
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();

        // 将redis连接工厂与模板对象进行绑定
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        // 设置json序列化对象
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        // 进行redis key值的序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 设置redis value的序列化
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        // 设置hash key的序列化
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        // 设置hash value的序列化
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();

        return redisTemplate;
    }*/

    /**
     * 自己定义的一个RedisTemplate
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<String, Object> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);

        // json序列化配置
        Jackson2JsonRedisSerializer<Object> objectJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        objectJackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        // String的序列化
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

        // 配置具体的序列化方式
        // redis key采用string的序列化方式
        template.setKeySerializer(stringRedisSerializer);
        // redis value采用json的序列化方式
        template.setValueSerializer(objectJackson2JsonRedisSerializer);
        // hash key采用string的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        // hash value采用json的序列化方式
        template.setHashValueSerializer(objectJackson2JsonRedisSerializer);
        template.afterPropertiesSet();

        return template;
    }
}
