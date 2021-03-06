package com.dkatalis.demo.product.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HomeController {

    @GetMapping("/hello")
    public String home() {
        log.info("#product-service called!");
        return "hello world from product!";
    }
}
