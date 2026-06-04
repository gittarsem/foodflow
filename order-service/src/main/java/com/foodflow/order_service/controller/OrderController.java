package com.foodflow.order_service.controller;

import com.foodflow.common.OrderCreatedEvent;
import com.foodflow.order_service.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    KafkaProducerService producer;

    @PostMapping
    public String createOrder(){
        Random random=new Random();
        OrderCreatedEvent event=new OrderCreatedEvent(
                UUID.randomUUID().toString(),
                "User_"+ random.nextInt(1000),
                500+(10000-500)*random.nextDouble()
        );

        producer.send(event);
        return "ORDER CREATED";
    }
}
