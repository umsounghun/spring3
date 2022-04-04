package com.sparta.spring31.dto;

import lombok.Getter;

@Getter
public class FoodDto {
    private Long retaurantId;
    private String name;
    private Long price;

    public FoodDto(Long retaurantId, String name, Long price) {
        this.retaurantId = retaurantId;
        this.name =  name;
        this.price = price;
    }
}

