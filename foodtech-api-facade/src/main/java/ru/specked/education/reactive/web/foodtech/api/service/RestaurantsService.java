package ru.specked.education.reactive.web.foodtech.api.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.specked.education.reactive.web.foodtech.api.controller.dto.RestaurantDto;

@Slf4j
@Service
public class RestaurantsService {

    private final String RESTAURANTS_API_URL = "http://restaurants-service:8081/restaurants";
    private final WebClient webClient;

    public RestaurantsService() {
        this.webClient = WebClient.create(RESTAURANTS_API_URL);
    }

    public Flux<RestaurantDto> getRestaurants() {
        log.info("Getting restaurants...");
        return webClient.get()
                .exchange().flatMapMany(
                        clientResponse -> clientResponse.bodyToFlux(RestaurantDto.class)
                );
    }

    public Mono<String> getRestaurantMenu(Long restaurantId) {
        log.info("Getting menu for restaurant: {}", restaurantId);
        return webClient.get()
                .retrieve()
                .bodyToMono(String.class);
    }

}
