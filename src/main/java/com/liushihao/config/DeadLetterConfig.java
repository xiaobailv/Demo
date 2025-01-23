package com.liushihao.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 死信队列声明Exchange&Queue
 * 实现死信的四种方式
 *  1. requeue设置为false，消息被消费者拒绝即为死信
 *  2.1 发送消息时设置消息的生存时间，消息超过时间还没有被消费即为死信
 *  2.2 设置队列的生存时间属性，如果生存时间到了，还没有被消费即为死信
 *  3. 设置队列的最大长度，超过最大长度的消息即为死信
 *  4. 设置消息重新放回到队列的限制次数，requeue设置为true，消费者没有消费，超过次数即为死信（不重要）
 * @author 11092
 * @date 2024-12-29 13:50
 */
@Configuration
public class DeadLetterConfig {

    public static final String NORMAL_EXCHANGE = "normal_exchange";
    public static final String NORMAL_QUEUE = "normal_queue";
    public static final String NORMAL_ROUTING_KEY = "normal.#";

    public static final String DEAD_EXCHANGE = "dead_exchange";
    public static final String DEAD_QUEUE = "dead_queue";
    public static final String DEAD_ROUTING_KEY = "dead.#";

    @Bean
    public Exchange normalExchange() {
        return ExchangeBuilder.topicExchange(NORMAL_EXCHANGE).build();
    }

    @Bean
    public Queue normalQueue() {
        return QueueBuilder.durable(NORMAL_QUEUE)
                .deadLetterExchange(DEAD_EXCHANGE)
                .deadLetterRoutingKey("dead.abc")
//                .ttl(10000)
//                .maxLength(1)
//                .deliveryLimit(3)
                .build();
    }

    @Bean
    public Binding normalBinding(Queue normalQueue, Exchange normalExchange) {
        return BindingBuilder.bind(normalQueue).to(normalExchange).with(NORMAL_ROUTING_KEY).noargs();
    }

    @Bean
    public Exchange deadExchange() {
        return ExchangeBuilder.topicExchange(DEAD_EXCHANGE).build();
    }

    @Bean
    public Queue deadQueue() {
        return QueueBuilder.durable(DEAD_QUEUE).build();
    }

    @Bean
    public Binding deadBinding(Queue deadQueue, Exchange deadExchange) {
        return BindingBuilder.bind(deadQueue).to(deadExchange).with(DEAD_ROUTING_KEY).noargs();
    }
}
