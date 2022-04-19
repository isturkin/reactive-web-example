package ru.specked.education.reactive.web.foodtech.api.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class OrderDto {

    private Long restaurantId;
    private List<String> orderItems;
}
