package ru.specked.education.reactive.web.foodtech.api.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.specked.education.reactive.web.foodtech.api.controller.dto.OrderDto;
import ru.specked.education.reactive.web.foodtech.api.repository.OrderEntity;
import ru.specked.education.reactive.web.foodtech.api.repository.OrdersRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;

    public Mono<UUID> createOrder(OrderDto orderDto) {
        log.info("Creating new order...");
        return ordersRepository.save(
                mapToEntity(orderDto)).map(OrderEntity::getOrderId);
    }

    public Flux<OrderDto> getOrdersInRestaurant(Long restaurantId) {
        log.info("Try to get all orders in restaurant with id: {}", restaurantId);
        Flux<OrderEntity> orders = ordersRepository.findByRestaurantId(restaurantId);
        return orders.map(this::mapToDto);
    }

    private OrderEntity mapToEntity(OrderDto orderDto) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(UUID.randomUUID());
        orderEntity.setRestaurantId(orderDto.getRestaurantId());
        orderEntity.setOrderItems(orderDto.getOrderItems());
        return orderEntity;
    }

    private OrderDto mapToDto(OrderEntity orderEntity) {
        OrderDto orderDto = new OrderDto();
        orderDto.setRestaurantId(orderEntity.getRestaurantId());
        orderDto.setOrderItems(orderEntity.getOrderItems());
        return orderDto;
    }
}
