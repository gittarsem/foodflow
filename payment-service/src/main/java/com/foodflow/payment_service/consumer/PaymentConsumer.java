package com.foodflow.payment_service.consumer;

import com.foodflow.common.OrderCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {

    @KafkaListener(
            topics="order-created",
            groupId = "payment-group"
    )
    public void consumer(OrderCreatedEvent event){
        System.out.println("ORDER RECEIVED");
        System.out.println(event);
        System.out.println(event.getAmount()>2000?"PAYMENT SUCCESS":"PAYMENT FAILED");
    }
}
