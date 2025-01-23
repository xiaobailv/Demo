package com.liushihao.rabbitmq.routing;

import com.liushihao.util.RabbitMQConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author 11092
 * @date 2024-12-29 13:50
 */
public class Publisher {

    private static final String EXCHANGE_NAME = "ROUTING_EXCHANGE";
    private static final String QUEUE_NAME1 = "ROUTING_QUEUE1";
    private static final String QUEUE_NAME2 = "ROUTING_QUEUE2";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        channel.queueDeclare(QUEUE_NAME1, true, false, false, null);
        channel.queueDeclare(QUEUE_NAME2, true, false, false, null);
        channel.queueBind(QUEUE_NAME1, EXCHANGE_NAME, "ORANGE");
        channel.queueBind(QUEUE_NAME2, EXCHANGE_NAME, "BLACK");
        channel.queueBind(QUEUE_NAME2, EXCHANGE_NAME, "WHITE");
        channel.basicPublish(EXCHANGE_NAME, "ORANGE", null, ("橙色").getBytes());
        channel.basicPublish(EXCHANGE_NAME, "BLACK", null, ("黑色").getBytes());
        channel.basicPublish(EXCHANGE_NAME, "GREEN", null, ("绿色").getBytes());
        channel.basicPublish(EXCHANGE_NAME, "WHITE", null, ("白色").getBytes());
    }
}
