package com.example.search.config;

import com.example.search.enumtype.QueueEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

/**
 * @author freedom
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue emailQueue() {
        return new Queue(QueueEnum.QUEUE_EMAIL.getName(), true);
    }

    @Bean
    public DirectExchange emailExchange() {
        return new DirectExchange(QueueEnum.QUEUE_EMAIL.getExchange());
    }

    @Bean
    public Binding emailBinding(Queue emailQueue, DirectExchange emailExchange) {
        return BindingBuilder.bind(emailQueue).to(emailExchange).with(QueueEnum.QUEUE_EMAIL.getRouteKey());
    }

    /**
     * 解决AMPQ安全问题报错
     *
     * @return
     */
    @Bean
    public SimpleMessageConverter converter() {
        SimpleMessageConverter converter = new SimpleMessageConverter();
        converter.setAllowedListPatterns(Collections.singletonList("java.util.*"));
        return converter;
    }
}
