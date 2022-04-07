package com.sparta.spring31.controller;


import com.sparta.spring31.dto.OrdersRequestDto;
import com.sparta.spring31.dto.OrdersResponseDto;
import com.sparta.spring31.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    // 음식점 조회
    @GetMapping("/orders")
    public List<OrdersResponseDto> findAllOrder() {
        return orderService.findAllOrder();
    }

    // 음식점 등록
    @PostMapping("/order/request")
    public OrdersResponseDto orderFood (@RequestBody OrdersRequestDto ordersRequestDto) {
        return orderService.orders(ordersRequestDto);
    }
}