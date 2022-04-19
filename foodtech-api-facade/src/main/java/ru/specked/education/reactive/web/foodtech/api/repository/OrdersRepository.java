package ru.specked.education.reactive.web.foodtech.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrdersRepository extends MongoRepository<OrderEntity, UUID> {

    List<OrderEntity> findByRestaurantId(Long restaurantId);
}
