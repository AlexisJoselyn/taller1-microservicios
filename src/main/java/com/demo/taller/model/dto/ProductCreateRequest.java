package com.demo.taller.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ProductCreateRequest {
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9 ]+$")
    private String name;

    @Min(0)
    private double price;

    @Min(0)
    private int stock;
}
