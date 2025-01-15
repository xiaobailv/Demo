package com.liushihao.service.impl;

import com.liushihao.dao.ProductDao;
import com.liushihao.entity.Product;
import com.liushihao.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author 11092
 * @date 2024-12-29 13:50
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public Product getProductById(int id) {
        String key = "product:" + id;
        if (redisTemplate.hasKey(key)) {
            System.out.println("执行缓存。。。");
            Product product = (Product)redisTemplate.opsForValue().get(key);
            return product;
        }
        System.out.println("执行MySQL。。。");
        Product product = productDao.getProductById(id);
        redisTemplate.opsForValue().set(key, product);
        return product;
    }
}
