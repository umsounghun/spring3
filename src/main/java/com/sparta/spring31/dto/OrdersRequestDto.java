package com.sparta.spring31.dto;

import com.sparta.spring31.model.OrderItem;

import lombok.Getter;

import java.util.List;

@Getter
public class OrdersRequestDto {

    private Long restaurantId;
    private List<OrderItem> foods;
    }


