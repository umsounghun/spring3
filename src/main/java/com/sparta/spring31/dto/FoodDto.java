package com.sparta.spring31.dto;

import lombok.Getter;

@Getter
public class FoodDto {
    private String name;
    private Long price;

    public FoodDto(String name, Long price) {
        this.name =  name;
        this.price = price;
    }
}

