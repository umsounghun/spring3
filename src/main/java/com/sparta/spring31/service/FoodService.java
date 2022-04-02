package com.sparta.spring31.service;

import com.sparta.spring31.dto.FoodRequestDto;
import com.sparta.spring31.model.Food;
import com.sparta.spring31.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FoodService {

    private final FoodRepository FoodRepository;

    // 댓글 조회
    public List<Food> getFood(Long postId) {
        return FoodRepository.findAllByPostidOrderByCreatedAtDesc(postId);
    }

    // 댓글 작성
    @Transactional
    public Food createFood(FoodRequestDto requestDto, Long userId) {
        String replyCheck = requestDto.getFood();
        if (replyCheck.contains("script")|| replyCheck.contains("<")||replyCheck.contains(">")){
            Food food = new Food(requestDto, userId,"xss 안돼요,, 하지마세요ㅠㅠ");
            FoodRepository.save(food);
            return food;
        }
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Food food = new Food(requestDto, userId);
        FoodRepository.save(food);
        return food;
    }

}