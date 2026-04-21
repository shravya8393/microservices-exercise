package com.microservices.productservice.kafka;

import com.microservices.productservice.event.CartEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "cart-topic", groupId = "product-group")
    public void consume(CartEvent event) {

        System.out.println(" EVENT RECEIVED IN PRODUCT SERVICE ");
        System.out.println("Cart ID: " + event.getCartId());
        System.out.println("Product ID: " + event.getProductId());
        System.out.println("Quantity: " + event.getQuantity());
    }
}