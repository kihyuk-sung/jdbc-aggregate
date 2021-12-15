package com.example.jdbcaggregate.order;

import org.springframework.data.annotation.Id;

import java.util.Set;

public class Order {
    @Id
    private Long id;
    private String shippingAddress;

    private Set<OrderItem> orderItems;

    public int getOrderItemsCounts() {
        return orderItems.size();
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }
}
