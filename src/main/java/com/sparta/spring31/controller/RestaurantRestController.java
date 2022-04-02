package com.sparta.spring31.controller;



import com.sparta.spring31.dto.RestaurantRequestDto;
import com.sparta.spring31.model.Restaurant;
import com.sparta.spring31.repository.RestaurantRepository;
import com.sparta.spring31.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantRestController {

    private final RestaurantRepository RestaurantRepository;
    private final RestaurantService RestaurantService;

    // 음식점 조회
    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurant() {
        return RestaurantRepository.findAll();
    }

//    // 게시글 특정 조회
//    @GetMapping("/api/contents/{id}")
//    public Restaurant getContents(@PathVariable Long id) {
//        Restaurant restaurant =  RestaurantRepository.findById(id).orElseThrow(
//                ()->new IllegalArgumentException("rstaurantId가 존재하지 않습니다."));
//        return restaurant;
//    }

    // 음식점 등록
    @PostMapping("/restaurant/register")
    public Restaurant createCRestaurant(@RequestBody RestaurantRequestDto requestDto) {
        Restaurant Restaurant = new Restaurant(requestDto);



        return RestaurantRepository.save(Restaurant);
    }
}