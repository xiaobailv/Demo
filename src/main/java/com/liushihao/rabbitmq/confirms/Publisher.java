package com.liushihao.rabbitmq.confirms;

import com.liushihao.util.RabbitMQConnectionUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author 11092
 * @date 2024-12-29 13:50
 */
public class Publisher {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("confirms", true, false, false, null);
        channel.confirmSelect();
        // 保证消息成功发送到Exchange
        channel.addConfirmListener((deliveryTag, multiple) -> {
            System.out.println("消息成功到Exchange: " + deliveryTag);
        }, ((deliveryTag, multiple) -> {
            System.out.println("消息没有发送到Exchange，尝试重试，或者其他补偿操作: " + deliveryTag);
        }));
        // 设置Return回调，确认消息是否路由到了Queue；同时需要将channel.basicPublish()的mandatory参数设置为true
        channel.addReturnListener(((replyCode, replyText, exchange, routingKey, properties, body) -> {
            System.out.println("消息没有路由到指定队列，做其他的补偿措施!!");
        }));
        // 设置Queue消息持久化，deliveryMode(1) -> 不持久化; deliveryMode(2) -> 持久化
        AMQP.BasicProperties properties = new AMQP.BasicProperties()
                .builder()
                .deliveryMode(2)
                .build();
        String message = "Hello World!";
        channel.basicPublish("", "confirms", true, properties, message.getBytes());
        System.out.println("消息发送成功！");
    }
}
