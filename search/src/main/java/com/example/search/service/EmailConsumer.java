package com.example.search.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author freedom
 */
@Component
public class EmailConsumer {

    @Autowired
    private JavaMailSender javaMailSender;

    @RabbitListener(queues = "email_queue")
    public void handle(Map<String, Object> emailMessage) {
        String recipient = (String) emailMessage.get("recipient");
        String subject = (String) emailMessage.get("subject");
        String content = (String) emailMessage.get("content");

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipient);
        message.setSubject(subject);
        message.setText(content);
        message.setFrom("964663284@qq.com");

        javaMailSender.send(message);
    }
}
