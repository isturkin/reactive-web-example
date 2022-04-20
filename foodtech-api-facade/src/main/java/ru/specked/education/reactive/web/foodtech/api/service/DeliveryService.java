package ru.specked.education.reactive.web.foodtech.api.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class DeliveryService {

    private final String DELIVERY_API_URL = "http://delivery-service:8082/delivery";

    private final RestTemplate restTemplate;

    public void placeOrderForDelivery(UUID orderId) {
        log.info("Placing order {} for delivery...", orderId);
        String uri = UriComponentsBuilder.fromUri(URI.create(DELIVERY_API_URL))
                .path("/orders")
                .path("/{orderId}")
                .buildAndExpand(orderId.toString())
                .toUriString();
        restTemplate.postForEntity(uri, null, Void.class);
    }
}
