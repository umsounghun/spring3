package com.sparta.spring31.service;

import com.sparta.spring31.dto.FoodDto;
import com.sparta.spring31.dto.RestaurantDto;
import com.sparta.spring31.model.Food;
import com.sparta.spring31.model.Restaurant;
import com.sparta.spring31.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service

public class FoodService {

    private final FoodRepository foodRepository;
    
    public void registerFood(List<FoodDto> requestDtos, Long retaurantId) {

        for(int i = 0; i < requestDtos.size(); i++) {
            FoodDto requestDto = requestDtos.get(i);
            String name = requestDto.getName();
            Long price = requestDto.getPrice();


        // 조건에 해당하지 않으면 에러가 나옴
        if (price < 100 || price > 1000000) {
            throw new IllegalArgumentException("주문 가격은 100원 ~ 1,000,000원 입니다.");
        } else if (price % 100 != 0) {
            throw new IllegalArgumentException("주문가격은 100원 단위로만 가능합니다");
        }

            Food food = new Food(retaurantId, name, price);
            foodRepository.save(food);
        }
    }

}
