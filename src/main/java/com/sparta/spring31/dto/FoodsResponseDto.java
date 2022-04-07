package com.sparta.spring31.dto;


import com.sparta.spring31.model.OrderItem;
import lombok.Getter;

@Getter
public class FoodsResponseDto {
    private String name;
    private int quantity;
    private int price;

    public FoodsResponseDto(OrderItem orderItem) {
        this.name = orderItem.getName();
        this.quantity = orderItem.getQuantity();
        this.price = orderItem.getPrice();

    }
}