package com.liushihao.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 11092
 * @date 2024-12-29 13:50
 */
@Configuration
public class DelayedConfig {

    public static final String DELAY_EXCHANGE = "delay_exchange";
    public static final String DELAY_QUEUE = "delay_queue";
    public static final String DELAY_ROUTINGKEY = "delay.#";

    @Bean
    public Exchange delayExchange() {
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-delayed-type", "topic");
        Exchange delayExchange = new CustomExchange(DELAY_EXCHANGE, "x-delayed-message", true, false, arguments);
        return delayExchange;
    }

    @Bean
    public Queue delayQueue() {
        return QueueBuilder.durable(DELAY_QUEUE).build();
    }

    @Bean
    public Binding delayBinding(Queue delayQueue, Exchange delayExchange) {
        return BindingBuilder.bind(delayQueue).to(delayExchange).with(DELAY_ROUTINGKEY).noargs();
    }
}
