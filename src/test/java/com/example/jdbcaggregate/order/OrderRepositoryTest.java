package com.example.jdbcaggregate.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DataJdbcTest
class OrderRepositoryTest {
    @Autowired
    OrderRepository repository;

    @Test
    void getOne() {
        final Order order = repository.findById(1L).orElseThrow();
        assertThat(order).isNotNull();
        assertThat(order.getOrderItemsCounts()).isZero();
    }

    @Test
    void addOrderItem() {
        final Order order = repository.findById(1L).orElseThrow();
        order.addOrderItem(new OrderItem("Chicken", 10));
        order.addOrderItem(new OrderItem("Pizza", 10));
        repository.save(order);
        final Order addedOrder = repository.findById(1L).orElseThrow();
        assertThat(addedOrder.getOrderItemsCounts()).isEqualTo(2);
    }

    @Test
    void getAllOrders() {
        final List<Order> orders = repository.findAll();
        assertThat(orders).hasSize(3);
    }
}