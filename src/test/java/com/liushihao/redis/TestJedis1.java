package com.liushihao.redis;

import org.junit.Test;
import redis.clients.jedis.*;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 11092
 * @date 2024-12-29 13:50
 */
public class TestJedis1 {

    @Test
    public void standAloneTest() {
        Jedis jedis = new Jedis("192.168.18.20", 7001);
        for (String key : jedis.keys("*")) {
            System.out.println("key = " + key);
        }
    }

    @Test
    public void jedisPoolTest() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 资源池中的最大连接数
        jedisPoolConfig.setMaxTotal(20);
        // 资源池确保的最少空闲连接数
        jedisPoolConfig.setMinIdle(3);
        // 资源池允许的最大空闲连接数
        jedisPoolConfig.setMaxIdle(5);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "192.168.18.20", 7001);
        Jedis resource = jedisPool.getResource();
        for (String name : resource.lrange("num", 0, -1)) {
            System.out.print(name + " ");
        }
        System.out.println();
        resource.set("age", "1");
        System.out.println(resource.get("age"));
    }

    @Test
    public void jedisClusterTest() {
        Set<HostAndPort> hostAndPorts = new HashSet<>();
        hostAndPorts.add(new HostAndPort("192.168.18.20", 8001));
        hostAndPorts.add(new HostAndPort("192.168.18.20", 8002));
        hostAndPorts.add(new HostAndPort("192.168.18.20", 8003));
        hostAndPorts.add(new HostAndPort("192.168.18.20", 8004));
        hostAndPorts.add(new HostAndPort("192.168.18.20", 8005));
        hostAndPorts.add(new HostAndPort("192.168.18.20", 8006));
        JedisCluster jedisCluster = new JedisCluster(hostAndPorts);
        System.out.println(jedisCluster.get("age"));
        for (String num : jedisCluster.lrange("num", 0, -1)) {
            System.out.print(num + " ");
        }
        System.out.println();
        jedisCluster.rpush("num", "2");
        for (String num : jedisCluster.lrange("num", 0, -1)) {
            System.out.print(num + " ");
        }
    }
}
