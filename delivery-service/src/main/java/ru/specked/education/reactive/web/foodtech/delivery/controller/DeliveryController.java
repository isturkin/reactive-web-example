package ru.specked.education.reactive.web.foodtech.delivery.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.UUID;

@Slf4j
@RequestMapping("/delivery/orders")
@RestController
public class DeliveryController {

    @PostMapping("/{orderId}")
    public Mono<UUID> placeOrderForDelivery(@PathVariable("orderId") UUID orderId) {
        log.info("Placing an order for delivery: {}", orderId);
        return Mono.just(UUID.randomUUID())
                .delayElement(Duration.ofMillis(100L));
    }
}
