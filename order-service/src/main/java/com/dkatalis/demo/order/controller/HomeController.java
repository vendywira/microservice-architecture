package com.dkatalis.demo.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HomeController {

    private static final String TOPICS = "generate.order.c";

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private Tracer tracer;

    @GetMapping("/hello")
    public String home() {
        log.info("#order-service called!");
        return "hello world from order!";
    }

    @GetMapping("/generate-order-notification/{message}")
    public boolean generateOrderNotification(@PathVariable String message) {
        log.info("#generate-order-notification");
        String traceId = tracer.currentSpan().context().traceId();
        try {
            kafkaTemplate.send(TOPICS, traceId, "order-generate: "+ message);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
