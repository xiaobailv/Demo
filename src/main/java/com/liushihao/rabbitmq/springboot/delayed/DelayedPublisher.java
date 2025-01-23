package com.liushihao.rabbitmq.springboot.delayed;

import com.liushihao.config.DelayedConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 11092
 * @date 2024-12-29 13:50
 */
@SpringBootTest
public class DelayedPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testDelayedPublisher() {
        String message = "delayed message";
        rabbitTemplate.convertAndSend(DelayedConfig.DELAY_EXCHANGE, "delay.abc", message, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setDelay(3000);
                return message;
            }
        });
    }
}
