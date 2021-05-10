package com.liushihao.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestJedis {

    @Test
    public void testPing() {
        // 1. 获取Jedis对象
        Jedis jedis = new Jedis("192.168.252.131", 7001);
        // 2. Jedis所有的命令跟Redis命令行的指令是一样的. 测试连接
        System.out.println(jedis.ping());
    }

    @Test
    public void testKey() {
        Jedis jedis = new Jedis("192.168.252.131", 7001);
        System.out.println("清空数据: " + jedis.flushDB());
        System.out.println("判断某个key是否存在: " + jedis.exists("username"));
        System.out.println("新增<username, liush>的键值对: " + jedis.set("username", "liush"));
        System.out.println("新增<password, password>的键值对: " + jedis.set("password", "password"));
        System.out.println("系统中有如下key: ");
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
        System.out.println("删除键password: " + jedis.del("password"));
        System.out.println("判断key是否存在: " + jedis.exists("password"));
        System.out.println("查看username所存储的数据类型: " + jedis.type("username"));
        System.out.println("随机返回key中的一个: " + jedis.randomKey());
        System.out.println("重命名key: " + jedis.rename("username", "name"));
        System.out.println("取出改名后的值: " + jedis.get("name"));
        System.out.println("选择0号数据库: " + jedis.select(0));
        System.out.println("删除当前所选数据库中的所有数据: " + jedis.flushDB());
        System.out.println("查看当前数据库中的数据的存储大小: " + jedis.dbSize());
        System.out.println("删除所有数据库中的数据: " + jedis.flushAll());
    }

    @Test
    public void testString() {
        Jedis jedis = new Jedis("192.168.252.131", 7001);
        jedis.flushDB();
        System.out.println("================增加数据================");
        System.out.println(jedis.set("key1", "value1"));
        System.out.println(jedis.set("key2", "value2"));
        System.out.println(jedis.set("key3", "value3"));
        System.out.println("删除键key2: " + jedis.del("key2"));
        System.out.println("获取key2: " + jedis.get("key2"));
        System.out.println("修改key1: " + jedis.set("key1", "value1Change"));
        System.out.println("获取修改后的key1: " + jedis.get("key1"));
        System.out.println("在key3后面加入值: " + jedis.append("key3", "End"));
        System.out.println("key3的值: " + jedis.get("key3"));
        System.out.println("添加多个键值对: " + jedis.mset("key01", "value01", "key02", "value02", "key03", "value03"));
        System.out.println("获取多个键值对: " + jedis.mget("key01", "key02", "key03"));
        System.out.println("获取多个键值对: " + jedis.mget("key01", "key02", "key03", "key04"));
        System.out.println("删除多个键值对: " + jedis.del("key01", "key02"));
        System.out.println("获取多个键值对: " + jedis.mget("key01", "key02", "key03"));

        jedis.flushDB();
        System.out.println("=============新增键值对防止覆盖原先值=============");
        System.out.println(jedis.setnx("key1", "value1"));
        System.out.println(jedis.setnx("key2", "value2"));
        System.out.println(jedis.setnx("key2", "value-new"));
        System.out.println(jedis.get("key1"));
        System.out.println(jedis.get("key2"));

        System.out.println("=============新增键值对并设置有效时间=============");
        System.out.println(jedis.setex("key3", 3, "value3"));
        System.out.println(jedis.get("key3"));
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(jedis.get("key3"));

        System.out.println("===========获取原值, 更新为新值===========");
        System.out.println(jedis.getSet("key2", "key2GetSet"));
        System.out.println(jedis.get("key2"));


        System.out.println("获取key2的值的字符串: " + jedis.getrange("key2", 3, 6));
    }
}
