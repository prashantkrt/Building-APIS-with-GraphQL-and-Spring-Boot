package com.mylearning.grapghql.dto;

public record OrderInputRequestDto(String orderDetails, String orderStatus, Double orderPrice, String orderDate, String orderTime, String orderAddress) {
}
