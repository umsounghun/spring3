package com.sparta.spring31.controller;


import com.sparta.spring31.dto.FoodDto;
import com.sparta.spring31.model.Food;
import com.sparta.spring31.repository.FoodRepository;
import com.sparta.spring31.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FoodRestController {

    private final FoodRepository foodRepository;
    private final FoodService foodService;

    // 음식점 조회
    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getFood(@PathVariable Long restaurantId) {
        return foodRepository.findAll();
    }

    // 음식점 등록
    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void registerFood(@RequestBody FoodDto requestDto) {
        foodService.registerFood(requestDto);
    }

}

