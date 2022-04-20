package ru.specked.education.reactive.web.foodtech.restaurants.controller.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class RestaurantDto {

    private final String title;
    private final float rating;
}
