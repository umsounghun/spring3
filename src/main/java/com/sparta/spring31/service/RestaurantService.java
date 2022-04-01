package com.sparta.spring31.service;

import com.sparta.spring31.dto.RestaurantRequestDto;
import com.sparta.spring31.models.Restaurant;
import com.sparta.spring31.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository RestaurantRepository;

    @Transactional
    public Long update(@PathVariable Long id, @RequestBody RestaurantRequestDto requestDto) {
        Restaurant Restaurant = RestaurantRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        return Restaurant.getId();
    }
    }