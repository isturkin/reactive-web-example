package ru.specked.education.reactive.web.foodtech.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.specked.education.reactive.web.foodtech.api.repository.OrderEntity;
import ru.specked.education.reactive.web.foodtech.api.repository.OrdersRepository;

import java.util.Collections;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner mongoInserter(OrdersRepository ordersRepository) {
        return args -> {
            Random random = new Random();
            for (int i = 0; i < 1_000_000; i++) {
                OrderEntity orderEntity = new OrderEntity();
                orderEntity.setOrderId(UUID.randomUUID());
                orderEntity.setRestaurantId(random.nextLong());
                orderEntity.setOrderItems(Collections.singletonList("apple"));
                ordersRepository.save(orderEntity);
            }
        };
    }
}
