package ru.specked.education.reactive.web.foodtech.api.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@Service
public class DeliveryService {

    private final String DELIVERY_API_URL = "http://delivery-service:8082/delivery";

    private final WebClient webClient;

    public DeliveryService() {
        this.webClient = WebClient.create(DELIVERY_API_URL);
    }

    public Mono<Void> placeOrderForDelivery(UUID orderId) {
        log.info("Placing order {} for delivery...", orderId);
        return webClient.post()
                .exchange()
                .then();
    }
}
