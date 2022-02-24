package com.dkatalis.demo.notification.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationConsumer {

    @KafkaListener(topics = "generate.order.c", groupId = "${kafka.groupId}", containerFactory = "kafkaListenerContainerFactory")
    public void notificationListener(String message) {
        log.info("#notificationListener message : {}", message);
    }
}
