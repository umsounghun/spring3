package com.sparta.spring31.repository;

import com.sparta.spring31.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface OrderRepository extends JpaRepository<Orders, Long> {
}