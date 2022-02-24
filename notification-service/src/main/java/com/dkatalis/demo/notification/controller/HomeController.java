package com.dkatalis.demo.notification.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HomeController {

    @GetMapping("/hello")
    public String home() {
        log.info("#notification-service called!");
        return "hello world from notification!";
    }
}
