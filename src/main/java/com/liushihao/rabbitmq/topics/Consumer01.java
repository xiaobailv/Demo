package com.liushihao.rabbitmq.topics;

import com.liushihao.util.RabbitMQConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @author 11092
 * @date 2024-12-29 13:50
 */
public class Consumer01 {

    private static final String QUEUE_NAME = "TOPIC_QUEUE1";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        // 设置消息的流控 -> 每次拿到消息的个数
        channel.basicQos(1);
        // 监听消息
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println("消费者1号获取到消息：" + message);
            // 拿到消息后告诉生产者
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        };
        // 设置手动ack
        channel.basicConsume(QUEUE_NAME, false, deliverCallback, consumerTag -> {});
        System.out.println("开始监听队列");
    }
}
