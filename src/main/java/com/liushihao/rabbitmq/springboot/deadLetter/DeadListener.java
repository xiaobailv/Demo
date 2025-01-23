package com.liushihao.rabbitmq.springboot.deadLetter;

import com.liushihao.config.DeadLetterConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.IOException;

/**
 * 私信队列监听器
 * @author 11092
 * @date 2024-12-29 13:50
 */
//@Component
public class DeadListener {

    @RabbitListener(queues = DeadLetterConfig.NORMAL_QUEUE)
    public void consume(String msg, Channel channel, Message message) throws IOException {
        System.out.println("死信监听器接收到的消息：" + msg);
        // reject和Nack二选一
        channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
//        channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
    }
}
