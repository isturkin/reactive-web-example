package ru.specked.education.reactive.web.foodtech.delivery.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RequestMapping("/delivery/orders")
@RestController
public class DeliveryController {

    @PostMapping("/{orderId}")
    public void placeOrderForDelivery(@PathVariable("orderId") UUID orderId) throws InterruptedException {
        log.info("Placing an order for delivery: {}", orderId);
        Thread.sleep(5_000L);
        log.info("Order was added to delivery list!");
    }
}
