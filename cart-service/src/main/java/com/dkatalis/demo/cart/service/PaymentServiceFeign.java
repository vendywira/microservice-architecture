package com.dkatalis.demo.cart.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient("dk-payment-service")
public interface PaymentServiceFeign {

    @RequestMapping(value = "/hello", method = GET)
    String hello();
}
