package ru.specked.education.reactive.web.foodtech.api.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.specked.education.reactive.web.foodtech.api.controller.dto.RestaurantDto;

import java.net.URI;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class RestaurantsService {

    private final String RESTAURANTS_API_URL = "http://localhost:8081/restaurants";

    private final RestTemplate restTemplate;

    public List<RestaurantDto> getRestaurants() {
        log.info("Getting restaurants...");
        String uri = UriComponentsBuilder.fromUri(URI.create(RESTAURANTS_API_URL))
                .build()
                .toUriString();
        return restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<RestaurantDto>>(){}).getBody();
    }

    public String getRestaurantMenu(Long restaurantId) {
        log.info("Getting menu for restaurant: {}", restaurantId);
        String uri = UriComponentsBuilder.fromUri(URI.create(RESTAURANTS_API_URL))
                .path("/{restaurantId}")
                .path("/menu")
                .buildAndExpand(restaurantId)
                .toUriString();
        return restTemplate.getForObject(uri, String.class);
    }

}
