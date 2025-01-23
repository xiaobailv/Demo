package com.liushihao.rabbitmq.springboot.deadLetter;

import com.liushihao.config.DeadLetterConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 死信队列消息发布者
 * @author 11092
 * @date 2024-12-29 13:50
 */
@SpringBootTest
public class DeadPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void testDeadPublisher() {
        String message = "Dead Letter";
        rabbitTemplate.convertAndSend(DeadLetterConfig.NORMAL_EXCHANGE, "normal.abc", message);
    }

    @Test
    void testDeadPublisherExpire() {
        String message = "Dead Publisher Expire";
        rabbitTemplate.convertAndSend(DeadLetterConfig.NORMAL_EXCHANGE, "normal.abc", message, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setExpiration("5000");
                return message;
            }
        });
    }
}
