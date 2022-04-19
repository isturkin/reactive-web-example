package ru.specked.education.reactive.web.foodtech.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.specked.education.reactive.web.foodtech.api.controller.dto.OrderDto;
import ru.specked.education.reactive.web.foodtech.api.controller.dto.RestaurantDto;
import ru.specked.education.reactive.web.foodtech.api.service.DeliveryService;
import ru.specked.education.reactive.web.foodtech.api.service.OrdersService;
import ru.specked.education.reactive.web.foodtech.api.service.RestaurantsService;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class ApiFacadeController {

    private final RestaurantsService restaurantsService;
    private final OrdersService ordersService;
    private final DeliveryService deliveryService;

    @RequestMapping("/restaurants")
    @GetMapping
    public List<RestaurantDto> getRestaurants() {
        return restaurantsService.getRestaurants();
    }

    @RequestMapping("/restaurants/{restaurantId}/menu")
    @GetMapping
    public String getRestaurantMenu(@PathVariable("restaurantId") Long restaurantId) {
        return restaurantsService.getRestaurantMenu(restaurantId);
    }

    @RequestMapping("/orders")
    @PostMapping
    public UUID createOrder(@RequestBody OrderDto orderDto) {
        return ordersService.createOrder(orderDto);
    }

    @RequestMapping("/orders/restaurants/{restaurantId}")
    @GetMapping
    public List<OrderDto> getCreatedOrdersByRestaurantId(@PathVariable("restaurantId") Long restaurantId) {
        return ordersService.getOrdersInRestaurant(restaurantId);
    }

    @RequestMapping("/delivery/orders/{orderId}")
    @PostMapping
    public void placeOrderForDelivery(@PathVariable("orderId") UUID orderId) {
        deliveryService.placeOrderForDelivery(orderId);
    }
}
