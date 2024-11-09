package com.example.search.enumtype;

import lombok.Getter;

/**
 * @author freedom
 */
@Getter
public enum QueueEnum {
    /**
     * 邮件队列
     */
    QUEUE_EMAIL("email_queue", "email_exchange", "email_routing_key"),
    ;

    /**
     * 队列名称
     */
    private final String name;
    /**
     * 交换名称
     */
    private final String exchange;
    /**
     * 路由键
     */
    private final String routeKey;

    QueueEnum(String name, String exchange, String routeKey) {
        this.name = name;
        this.exchange = exchange;
        this.routeKey = routeKey;
    }
}
