package com.sparta.spring31.model;

import com.sparta.spring31.dto.FoodRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Food extends Timestamped {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private Long restaurantId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long price;


    public Food(Long restaurantId, String name, Long price) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.price = price;
    }

    public Food(FoodRequestDto requestDto) {
        this.restaurantId = requestDto.getRestruntId();
        this.name = requestDto.getName();
        this.price = requestDto.getPrice();
    }

//    public Food(FoodRequestDto requestDto, Long userId) {
//        this.RestaurantId = requestDto.getRestaurant();
//        this.price = requestDto.getPrice();
//        this.name = requestDto.getName();
//        this.userId = userId;
//    }
//    public Food(FoodRequestDto requestDto, Long userId, String price) {
//        this.RestaurantId = requestDto.getRestaurant();
//        this.price = price;
//        this.name = requestDto.getName();
//        this.userId = userId;
//    }
//
//    public void update(FoodRequestDto requestDto) {
//        this.price = requestDto.getPrice();
//    }
}

