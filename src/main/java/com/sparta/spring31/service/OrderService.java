package com.sparta.spring31.service;

import com.sparta.spring31.dto.FoodsResponseDto;
import com.sparta.spring31.dto.OrdersRequestDto;
import com.sparta.spring31.dto.OrdersResponseDto;
import com.sparta.spring31.model.Food;
import com.sparta.spring31.model.OrderItem;
import com.sparta.spring31.model.Orders;
import com.sparta.spring31.model.Restaurant;
import com.sparta.spring31.repository.FoodRepository;
import com.sparta.spring31.repository.OrderItemRepository;
import com.sparta.spring31.repository.OrderRepository;
import com.sparta.spring31.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;
    private final OrderItemRepository orderItemRepository;

    //음식 주문요청시
    @Transactional
    public OrdersResponseDto orders(OrdersRequestDto ordersRequestDto) {
        Restaurant restaurant = getRestaurant(ordersRequestDto);

        int totalPrice = 0;

        List<FoodsResponseDto> foodsResponseDtoList = new ArrayList<>();

        List<OrderItem> orderItems = ordersRequestDto.getFoods();

        List<OrderItem> orderItemList = new ArrayList<>();

        for (OrderItem tempOrderItem : orderItems) {

            int quantity = tempOrderItem.getQuantity();
            // 음식 주문 수량 허용값.
            if (quantity < 1 || quantity > 100) {
                throw new IllegalArgumentException("음식 주문 수량은 1 ~ 100미만입니다..");
            }
            Food food = getFood(tempOrderItem);
            OrderItem orderItem = OrderItem.builder() //빌더 패턴

                    .quantity(tempOrderItem.getQuantity())
                    .name(food.getName())
                    .price(food.getPrice() * quantity)// 주문음식 가격 * 수량.
                    .food(food)
                    .build();

            orderItemRepository.save(orderItem);

            FoodsResponseDto foodsResponseDto = new FoodsResponseDto(orderItem);

            foodsResponseDtoList.add(foodsResponseDto);

            totalPrice += food.getPrice() * quantity;

            orderItemList.add(orderItem);
        }

        if (totalPrice < restaurant.getMinOrderPrice()) { // 음식점 최소주문가격 맞추기.
            throw new IllegalArgumentException("음식점의 최소 주문 가격을 맞춰주세요.");
        }

        int deliveryFee = restaurant.getDeliveryFee();

        totalPrice += deliveryFee;

        Orders orders = Orders.builder()

                .restaurantName(restaurant.getName())
                .totalPrice(totalPrice)
                .foods(orderItemList)
                .build();

        orderRepository.save(orders);

        OrdersResponseDto ordersResponseDto = new OrdersResponseDto(orders, deliveryFee, foodsResponseDtoList);

        return ordersResponseDto;
    }


    private Restaurant getRestaurant(OrdersRequestDto ordersRequestDto) {

        //음식점을 찾는다 없으면 예외처리
        Restaurant restaurant = restaurantRepository.findById(ordersRequestDto.getRestaurantId())
                .orElseThrow(
                        () -> new NullPointerException("음식점이 없습니다.")
                );
        return restaurant;
    }

    // 음식 찾아서 없으면 예외처리 -> 해당 음식 없음.
    private Food getFood(OrderItem tempOrderItem) {

        return foodRepository.findById(tempOrderItem.getId())

                .orElseThrow(() -> new NullPointerException("해당 음식이 없습니다."));
    }

    //음식점 조회
    @Transactional
    public List<OrdersResponseDto> findAllOrder() {
        List<OrdersResponseDto> ordersResponseDtoList = new ArrayList<>();

        List<Orders> ordersList = orderRepository.findAll();

        // orderlist를 갖고와서 하나씩 orders에 넣음.
        for (Orders orders : ordersList) {
            int deliveryFee = restaurantRepository.findByName(orders.getRestaurantName()).getDeliveryFee();

            List<FoodsResponseDto> foodsResponseDtoList = new ArrayList<>();
            List<OrderItem> orderItemsList = orderItemRepository.findOrderItemsByOrders(orders);
            for (OrderItem orderItem : orderItemsList) {
                FoodsResponseDto foodsResponseDto = new FoodsResponseDto(orderItem);
                foodsResponseDtoList.add(foodsResponseDto);
            }

            OrdersResponseDto ordersResponseDto = new OrdersResponseDto(orders, deliveryFee, foodsResponseDtoList);
            ordersResponseDtoList.add(ordersResponseDto);
        }
        return ordersResponseDtoList;
    }
}