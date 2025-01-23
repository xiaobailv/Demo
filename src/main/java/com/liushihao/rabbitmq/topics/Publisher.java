package com.liushihao.rabbitmq.topics;

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

    private static final String EXCHANGE_NAME = "TOPIC_EXCHANGE";
    private static final String QUEUE_NAME1 = "TOPIC_QUEUE1";
    private static final String QUEUE_NAME2 = "TOPIC_QUEUE2";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC, true);
        channel.queueDeclare(QUEUE_NAME1, true, false, false, null);
        channel.queueDeclare(QUEUE_NAME2, true, false, false, null);
        channel.queueBind(QUEUE_NAME1, EXCHANGE_NAME, "*.orange.*");
        channel.queueBind(QUEUE_NAME2, EXCHANGE_NAME, "*.*.rabbit");
        channel.queueBind(QUEUE_NAME2, EXCHANGE_NAME, "lazy.#");
        channel.basicPublish(EXCHANGE_NAME, "big.orange.rabbit", null, "大橙兔子".getBytes());
        channel.basicPublish(EXCHANGE_NAME, "big.white.rabbit", null, "大白兔".getBytes());
        channel.basicPublish(EXCHANGE_NAME, "lazy.big.dog.dog.dog.dog", null, "懒大狗".getBytes());
    }
}
