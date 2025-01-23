package com.liushihao.rabbitmq.springboot;

import com.liushihao.config.RabbitMQConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.IOException;

/**
 * @author 11092
 * @date 2024-12-29 13:50
 */
//@Component
public class ConsumerListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receive(String message, Channel channel, Message msg) throws IOException {
        System.out.println("-----消费者接收消息-----");
        System.out.println("队列消息为：" + message);
        String correlationId = msg.getMessageProperties().getCorrelationId();
        System.out.println("唯一标识为：" + correlationId);
        channel.basicAck(msg.getMessageProperties().getDeliveryTag(), false);
    }
}
