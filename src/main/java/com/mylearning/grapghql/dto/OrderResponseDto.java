package com.mylearning.grapghql.dto;

public record OrderResponseDto(Integer orderId, String orderDetails, String orderStatus, Double orderPrice, String orderDate, String orderTime, String orderAddress) {}

