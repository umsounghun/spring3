package com.sparta.spring31.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {
    private String name;
    private int minOrderPrice;
    private int deliveryFee;
}