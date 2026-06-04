package com.foodflow.notification_service.service;

import com.foodflow.common.OrderCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

@Service
public class NotificationService {

    @KafkaListener(
            topics = "order-created",
            groupId = "notification-group"
    )
    public String Notification(OrderCreatedEvent event){

        System.out.println("======Notification======");
        System.out.println("Order Id : " + event.getOrderId());
        System.out.println("User Id : " + event.getUserId());
        System.out.println("Amount : " + event.getAmount());
        return "Sending Notification to User...";
    }
}
