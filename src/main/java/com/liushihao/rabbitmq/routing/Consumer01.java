package com.liushihao.rabbitmq.routing;

import com.liushihao.util.RabbitMQConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author 11092
 * @date 2024-12-29 13:50
 */
public class Consumer01 {

    private static final String QUEUE_NAME1 = "ROUTING_QUEUE1";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME1, true, false, false, null);
        channel.basicQos(1);
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody());
            System.out.println("消费者1号获取消息：" + message);
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        };
        channel.basicConsume(QUEUE_NAME1, false, deliverCallback, consumerTag -> {});
    }
}
