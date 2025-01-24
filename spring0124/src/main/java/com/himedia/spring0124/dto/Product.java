package com.himedia.spring0124.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 기본 키

    private String name;        // 상품명
    private int stockQuantity;  // 잔여 수량
    private String deliveryDate; // 배송 날짜
    private int price;          // 금액
    private int quantity;       // 수량

    // 스크랩, 하트, 공유, 댓글 수
    private int scrapCount = 0;
    private int heartCount = 0;
    private int shareCount = 0;

    // String 클래스 mysql varchar(255)
    @Lob
    private String imageUrl;    // 이미지 URL
}