package com.sparta.spring31.service;

import com.sparta.spring31.dto.RestaurantDto;
import com.sparta.spring31.model.Restaurant;
import com.sparta.spring31.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public Restaurant registerRestaurant(RestaurantDto requestDto) {

        //Getter로 받는 input 요소들
        String name = requestDto.getName();
        Long minOrderPrice = requestDto.getMinOrderPrice();
        Long deliveryFee = requestDto.getDeliveryFee();

        // 조건에 해당하지 않으면 에러가 나옴
        if (minOrderPrice < 1000 || minOrderPrice > 100000) {
            throw new IllegalArgumentException("최소주문 가격은 1,000원 ~ 100.000원입니다");
        } else if (minOrderPrice % 100 != 0) {
            throw new IllegalArgumentException("주문가격은 100원 단위로만 가능합니다");
        } else if (deliveryFee < 0 || deliveryFee > 10000) {
            throw new IllegalArgumentException("기본 배달비는 0원~10,000원입니다");
        } else if (deliveryFee % 500 != 0) {
            throw new IllegalArgumentException("기본 배달비는 500원 단위로만 가능합니다");
        } else if (name.length() < 1) {
            throw new IllegalArgumentException("가게이름을 입력하세요 ");
        }

        Restaurant restaurant = new Restaurant(name, minOrderPrice, deliveryFee);
        restaurantRepository.save(restaurant);
        return restaurant;

    }
}