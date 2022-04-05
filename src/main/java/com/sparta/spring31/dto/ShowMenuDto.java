package com.sparta.spring31.dto;

import lombok.Getter;

@Getter
public class ShowMenuDto {
    private  Long Id;
    private  Long restaurantId;
    private String name;
    private Long price;

    public ShowMenuDto(Long Id, Long restaurantId, String name, Long price) {
        this.Id = Id;
        this.restaurantId = restaurantId;
        this.name =  name;
        this.price = price;
    }
}

