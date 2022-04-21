package ru.specked.education.reactive.web.foodtech.api.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface OrdersRepository extends ReactiveMongoRepository<OrderEntity, UUID> {

    Flux<OrderEntity> findByRestaurantId(Long restaurantId);
}
