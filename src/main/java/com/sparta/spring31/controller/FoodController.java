package com.sparta.spring31.controller;

import com.sparta.spring31.dto.FoodRequestDto;

import com.sparta.spring31.model.Food;
import com.sparta.spring31.repository.FoodRepository;
import com.sparta.spring31.security.UserDetailsImpl;
import com.sparta.spring31.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FoodController {

    private final FoodRepository FoodRepository;
    private final FoodService FoodService;

    // 로그인한 회원이 등록한 상품들 조회
    @GetMapping("/restaurant/{restaurantId}/food")
    public List<Food> getFood(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        Long userId = userDetails.getUser().getId();
        return FoodService.getFood(userId);
    }

//    // 게시글 id 로 댓글 조회
//    @GetMapping("/api/reply/{postId}")
//    public List<Food> getFood(@PathVariable Long postId) {
//        return FoodService.getFood(postId);
//    }

    // 댓글 작성
    @PostMapping("/restaurant/{restaurantId}/food/regiser")
    public boolean createReply(@RequestBody FoodRequestDto requestDto) {
        // 로그인 되어 있는 ID
        if (userDetails != null) {
            Long userId = userDetails.getRestaur().getId();
            FoodService.createFood(requestDto, userId);
            return true;
        }
        return false;
    }


}