package com.sparta.spring31.dto;

import lombok.Getter;
import lombok.Setter;


//@Component
@Getter
@Setter
public class FoodRequestDto {
    // [{"id":null,"name":"쉑버거 더블","price":10900}]

    private String name;

    private int price;

    private Long id;


}
