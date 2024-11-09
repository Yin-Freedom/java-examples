package com.example.search.service;

import com.example.search.enumtype.QueueEnum;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author freedom
 */
@Service
public class EmailService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendEmail(String recipient, String subject, String content) {
        Map<String, Object> emailMessage = new HashMap<>();
        emailMessage.put("recipient", recipient);
        emailMessage.put("subject", subject);
        emailMessage.put("content", content);

        rabbitTemplate.convertAndSend(QueueEnum.QUEUE_EMAIL.getExchange(),
                QueueEnum.QUEUE_EMAIL.getRouteKey(),
                emailMessage);
    }
}
