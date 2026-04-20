package com.microservices.cartservice.kafka;

import com.microservices.cartservice.event.CartEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "cart-topic";

    @Autowired
    private KafkaTemplate<String, CartEvent> kafkaTemplate;

    public void sendEvent(CartEvent event) {
        kafkaTemplate.send(TOPIC, event);
        System.out.println("Sent to Kafka: " + event);
    }
}
