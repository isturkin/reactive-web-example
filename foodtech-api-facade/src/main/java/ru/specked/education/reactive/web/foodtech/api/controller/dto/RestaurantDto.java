package ru.specked.education.reactive.web.foodtech.api.controller.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class RestaurantDto {

    private String title;
    private float rating;
}
