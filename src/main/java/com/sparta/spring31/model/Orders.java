package com.sparta.spring31.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
@Builder
@AllArgsConstructor
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
public class Orders {

    // strategy = GenerationType.IDENTITY
    // 기본키 생성을 데이터베이스에게 위임하는 방식으로 id값을 따로 할당하지 않아도 데이터베이스가 자동으로 AUTO_INCREMENT를 하여 기본키를 생성해준다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    // nullable = false 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String restaurantName;

    @Column(nullable = false)
    private int totalPrice;

    // CascadeType.ALL : 상위 엔터티에서 하위 엔터티로 모든 작업을 전파
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orders_id")
    private List<OrderItem> foods;

}

// 상위 엔티티에서 하위 엔티티로 모든 작업을 전파
//Cascade옵션 - OneToMany 나 ManytoOne에 옵션으로 줄 수 있는 값.
// Entity의 상태변화를 전파 시키는 옵션, 만약 Entity의 상태변화가 있으면 연관되어있는 OneToMany 나 ManyToOne
// 에도 상태 변화를 전이 시키는 옵션, 기본적으로는 아무것도 전이 시키지 않는다.
//  외래키를 매핑할 때 사용, name 속성에 매핑할 외래키 이름 지정.