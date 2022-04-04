package com.sparta.spring31.controller;



import com.sparta.spring31.dto.RestaurantDto;
import com.sparta.spring31.model.Restaurant;
import com.sparta.spring31.repository.RestaurantRepository;
import com.sparta.spring31.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantRestController {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantService restaurantService;

    // 음식점 조회
    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurant() {
        return restaurantRepository.findAll();
    }

    // 음식점 등록
    @PostMapping("/restaurant/register")
    public Restaurant registerRestaurant(@RequestBody RestaurantDto requestDto) {

        return restaurantService.registerRestaurant(requestDto);
    }
}