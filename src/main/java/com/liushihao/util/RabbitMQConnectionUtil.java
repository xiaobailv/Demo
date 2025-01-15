package com.liushihao.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * RabbitMQ的连接工具类
 * @author 11092
 * @date 2024-12-29 13:50
 */
public class RabbitMQConnectionUtil {

    public static final String RABBITMQ_HOST = "192.168.18.111";
    public static final int RABBITMQ_PORT = 5672;
    public static final String RABBITMQ_USERNAME = "guest";
    public static final String RABBITMQ_PASSWORD = "guest";
    public static final String RABBITMQ_VIRTUAL_HOST = "/";

    /**
     * 获取RabbitMQ连接对象
     * @return 连接对象
     */
    public static Connection getConnection() throws IOException, TimeoutException {
        // 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 设置连接属性
        connectionFactory.setHost(RABBITMQ_HOST);
        connectionFactory.setPort(RABBITMQ_PORT);
        connectionFactory.setUsername(RABBITMQ_USERNAME);
        connectionFactory.setPassword(RABBITMQ_PASSWORD);
        connectionFactory.setVirtualHost(RABBITMQ_VIRTUAL_HOST);
        // 返回工厂
        return connectionFactory.newConnection();
    }
}
