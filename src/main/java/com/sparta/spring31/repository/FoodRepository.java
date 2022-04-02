package com.sparta.spring31.repository;

import com.sparta.spring31.model.Food;
import com.sparta.spring31.model.Restaurant;
import com.sparta.spring31.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
//    List<Reply> findAllByPostid(Long postId);
    List<Food> findAllByrestaurantIdOrderByCreatedAtDesc(Long restaurantId);
}