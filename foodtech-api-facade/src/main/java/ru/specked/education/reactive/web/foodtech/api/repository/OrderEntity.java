package ru.specked.education.reactive.web.foodtech.api.repository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Document(collection = "orders")
public class OrderEntity {

    @Id
    private UUID orderId;

    private Long restaurantId;

    private List<String> orderItems;
}
