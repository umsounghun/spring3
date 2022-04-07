package com.sparta.spring31.dto;

import lombok.Getter;

@Getter
public class FoodDto {
    private  Long restaurantId;
    private String name;
    private int price;

    public FoodDto(Long restaurantId, String name, int price) {
        this.restaurantId = restaurantId;
        this.name =  name;
        this.price = price;
    }
}

