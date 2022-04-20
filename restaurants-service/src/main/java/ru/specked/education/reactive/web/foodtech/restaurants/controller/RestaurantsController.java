package ru.specked.education.reactive.web.foodtech.restaurants.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.specked.education.reactive.web.foodtech.restaurants.controller.dto.RestaurantDto;

import java.time.Duration;
import java.util.Arrays;

@Slf4j
@RequestMapping("/restaurants")
@RestController
public class RestaurantsController {

    @GetMapping
    public Flux<RestaurantDto> getRestaurants() {
        log.info("Getting restaurants list...");
        return Flux.fromIterable(Arrays.asList(
                new RestaurantDto("SuperRestaurant", 5),
                new RestaurantDto("BadRestaurant", 2),
                new RestaurantDto("UsualRestaurant", 4)))
                .delayElements(Duration.ofMillis(1_000));
    }

    @GetMapping("/{restaurantId}/menu")
    public Mono<String> getRestaurantMenu(@PathVariable("restaurantId") Long restaurantId) {
        log.info("Getting menu for restaurant {}", restaurantId);
        return Mono.just("Fruits, vegetables, lemonade");
    }
}
