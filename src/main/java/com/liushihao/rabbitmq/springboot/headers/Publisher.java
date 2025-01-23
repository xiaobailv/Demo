package com.liushihao.rabbitmq.springboot.headers;

import com.liushihao.util.RabbitMQConnectionUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * Headers类型的绑定方式
 * 可以使用key-value类型的Map作为匹配参数，相较于Routing key更加灵活
 * @author 11092
 * @date 2024-12-29 13:50
 */
public class Publisher {

    public static final String HEADERS_EXCHANGE = "headers_exchange";
    public static final String HEADERS_QUEUE = "headers_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 1. 获取连接对象
        Connection connection = RabbitMQConnectionUtil.getConnection();
        // 2. 构建channel对象
        Channel channel = connection.createChannel();
        // 3. 创建Exchange和QUEUE并基于Headers的方式绑定
        channel.exchangeDeclare(HEADERS_EXCHANGE, BuiltinExchangeType.HEADERS);
        channel.queueDeclare(HEADERS_QUEUE, true, false, false, null);
        Map<String, Object> argument = new HashMap<>();
        // 多个header的key-value只要可以匹配上一个就可以
        argument.put("x-match", "any");
        // 多个header的key-value要求全部匹配上！
//        argument.put("x-match", "all");
        argument.put("name", "jack");
        argument.put("age", "23");
        channel.queueBind(HEADERS_QUEUE, HEADERS_EXCHANGE, "", argument);
        // 4. 发送消息
        Map<String, Object> headers = new HashMap<>();
        headers.put("name", "rose");
        headers.put("age", "23");
        AMQP.BasicProperties properties = new AMQP.BasicProperties()
                .builder()
                .headers(headers)
                .build();
        String message = "Headers Exchange Message!!!";
        channel.basicPublish(HEADERS_EXCHANGE, "", properties, message.getBytes());
        System.out.println("消息发送成功，headers = " + headers);
    }
}
