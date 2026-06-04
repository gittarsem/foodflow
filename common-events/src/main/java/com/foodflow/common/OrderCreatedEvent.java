package com.foodflow.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderCreatedEvent {
    private String orderId;
    private String userId;
    private Double amount;

    public OrderCreatedEvent(String orderId, String userId, Double amount) {
        this.orderId = orderId;
        this.userId = userId;
        this.amount = amount;
    }

}
