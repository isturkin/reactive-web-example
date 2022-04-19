package ru.specked.education.reactive.web.foodtech.restaurants.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.specked.education.reactive.web.foodtech.restaurants.controller.dto.RestaurantDto;

import java.util.Collections;
import java.util.List;

@Slf4j
@RequestMapping("/restaurants")
@RestController
public class RestaurantsController {

    @GetMapping
    public List<RestaurantDto> getRestaurants() throws InterruptedException {
        log.info("Getting restaurants...");
        Thread.sleep(20_000L);
        return Collections.emptyList();
    }

    @GetMapping("/{restaurantId}/menu")
    public String getRestaurantMenu(@PathVariable("restaurantId") Long restaurantId) {
        log.info("Getting menu for restaurant {}", restaurantId);
        return "Fruits, vegetables, lemonade";
    }
}
