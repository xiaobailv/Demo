package com.liushihao.redis;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestRedisAfair {

    @Test
    public void testAffair() {
        Jedis jedis = new Jedis("192.168.252.131", 7001);
        jedis.flushDB();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello", "world");
        jsonObject.put("name", "liush");

        // 开启事务
        Transaction multi = jedis.multi();
        String result = jsonObject.toJSONString();
        System.out.println("result = " + result);
        try {
            multi.set("user1", result);
            multi.set("user2", result);
            multi.get("key1");
            multi.exec();
        } catch (Exception e) {
            e.printStackTrace();
            multi.discard();
        } finally {
            // 关闭连接
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();
        }
    }
}
