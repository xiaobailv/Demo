package com.liushihao.rabbitmq.pubsub;

import com.liushihao.util.RabbitMQConnectionUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author 11092
 * @date 2024-12-29 13:50
 */
public class Publisher {

    private static final String EXCHANGE_NAME = "PUB_SUB_EXCHANGE";
    private static final String QUEUE_NAME1 = "PUB_SUB_QUEUE1";
    private static final String QUEUE_NAME2 = "PUB_SUB_QUEUE2";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 获取连接对象
        Connection connection = RabbitMQConnectionUtil.getConnection();
        // 构建channel
        Channel channel = connection.createChannel();
        // 构建交换机
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
        // 构建队列
        channel.queueDeclare(QUEUE_NAME1, true, false, false, null);
        channel.queueDeclare(QUEUE_NAME2, true, false, false, null);
        // 绑定交换机和队列，使用的是FANOUT类型的交换机，绑定方式是直接绑定
        channel.queueBind(QUEUE_NAME1, EXCHANGE_NAME, "");
        channel.queueBind(QUEUE_NAME2, EXCHANGE_NAME, "");
        // 发送消息到交换机
        String message = "Publish/Subscribe";
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
    }
}
