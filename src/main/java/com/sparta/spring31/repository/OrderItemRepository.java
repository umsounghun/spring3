package com.sparta.spring31.repository;

import com.sparta.spring31.model.Food;
import com.sparta.spring31.model.OrderItem;
import com.sparta.spring31.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findOrderItemsByOrders(Orders orders);
}