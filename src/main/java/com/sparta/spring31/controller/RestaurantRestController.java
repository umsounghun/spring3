package com.sparta.spring31.controller;



import com.sparta.spring31.dto.RestaurantRequestDto;
import com.sparta.spring31.models.Restaurant;
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

    // 게시글 전체 조회
    @GetMapping("/api/contents")
    public List<Restaurant> getRestaurant() {
        return RestaurantRepository.findAllByOrderByCreatedAtDesc();
    }

    // 게시글 특정 조회
    @GetMapping("/api/contents/{id}")
    public Restaurant getContents(@PathVariable Long id) {
        Restaurant restaurant =  RestaurantRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("rstaurantId가 존재하지 않습니다."));
        return restaurant;
    }

    // 게시글 생성
    @PostMapping("/api/contents")
    public Restaurant createCRestaurant(@RequestBody RestaurantRequestDto requestDto) {
        Restaurant Restaurant = new Restaurant(requestDto);
        return RestaurantRepository.save(Restaurant);
    }
}