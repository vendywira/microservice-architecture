package com.dkatalis.demo.cart.controller;

import com.dkatalis.demo.cart.service.OrderServiceFeign;
import com.dkatalis.demo.cart.service.PaymentServiceFeign;
import com.dkatalis.demo.cart.service.ProductServiceFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HomeController {

    @Autowired
    private ProductServiceFeign productService;

    @Autowired
    private OrderServiceFeign orderService;

    @Autowired
    private PaymentServiceFeign paymentService;

    @Autowired
    private Tracer tracer;

    @GetMapping("/hello")
    public String home() {
        log.info("#cart-service called!");
        return "hello world from cart!";
    }

    @GetMapping("/call-product")
    public String callProduct() {
        log.info("#cart-service call product from cart service!");
        return productService.hello();
    }

    @GetMapping("/call-all-services")
    public String  callAllServices() {
        log.info("#cart-service call product from cart service!");
        productService.hello();
        orderService.hello();
        paymentService.hello();
        return "TraceId : " + tracer.currentSpan().context().traceId();
    }
}
