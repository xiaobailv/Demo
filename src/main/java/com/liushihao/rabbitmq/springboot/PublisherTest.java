package com.liushihao.rabbitmq.springboot;

import com.liushihao.config.RabbitMQConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 11092
 * @date 2024-12-29 13:50
 */
@SpringBootTest
public class PublisherTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void publisher() {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, "small.white.rabbit", "publisher message");
        System.out.println("publisher message send success...");
    }

    @Test
    public void publisherWithProps() {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, "small.white.rabbit", "publisherWithProps message", new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setCorrelationId("123");
                return message;
            }
        });
    }

    @Test
    void publisherWithConfirms() {
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                if (ack) {
                    System.out.println("消息已经送达到Exchange！！！");
                } else {
//                    Message returnedMessage = correlationData.getReturnedMessage();
//                    rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, "small.white.rabbit", "publisherWithConfirms message");
                    System.out.println("消息没有送到Exchange，需要做一些补偿措施！！！Retry！！！");
                }
            }
        });
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, "small.white.rabbit", "publisherWithConfirms message");
    }

    @Test
    void publisherWithReturn() {
        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
            @Override
            public void returnedMessage(ReturnedMessage returned) {
                String msg = new String(returned.getMessage().getBody());
                System.out.println("消息：" + msg + "路由队列失败！做补救措施！！！");
            }
        });
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, "small.white.rabbit", "publisherWithReturn message");
    }

    @Test
    void publisherWithBasicProperties() {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, "small.white.rabbit", "publisherWithBasicProperties message", new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                // 设置消息持久化
                message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                message.getMessageProperties().setCorrelationId("publisherWithBasicProperties");
                return message;
            }
        });
    }
}
