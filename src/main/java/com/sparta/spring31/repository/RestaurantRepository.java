package com.sparta.spring31.repository;

import com.sparta.spring31.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findAllByOrderByCreatedAtDesc();
}