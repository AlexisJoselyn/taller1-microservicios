package com.demo.taller.model.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseResponse {
    private String productId;
    private int quantity;
    private int remainingStock;
    private double totalAmount;
}
