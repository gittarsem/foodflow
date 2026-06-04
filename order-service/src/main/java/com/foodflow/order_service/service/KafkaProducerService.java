package com.foodflow.order_service.service;

import com.foodflow.common.OrderCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    public void send(OrderCreatedEvent event){
        kafkaTemplate.send(
                "order-created",
                event.getOrderId(),
                event
        );
        System.out.println("EVENT SENT TO KAFKA");
    }
}
