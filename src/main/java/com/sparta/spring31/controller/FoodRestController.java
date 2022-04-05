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

    // 음식점 음식메뉴 조회
    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> showMenu(@PathVariable Long restaurantId) {
        return foodRepository.findAllByRestaurantId(restaurantId);
    }

    // 음식점 음식메뉴 등록
    @PostMapping("/restaurant/{restaurantId}/food/register")
    // @PathVariable url을 통해서 값을 받는다
    // 하나가 Fooddto이고, 이것을 여러개 받기 위해서는 List형식으로 받아야 함
    public void registerFood(@RequestBody List<FoodDto> requestDto, @PathVariable Long restaurantId) {
        foodService.registerFood(requestDto, restaurantId);
    }
}

