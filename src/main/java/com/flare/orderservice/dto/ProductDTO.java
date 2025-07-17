package com.flare.orderservice.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private String model;
    private long id;
    private String title;
    private long categoryId;
    private String brand;
    private boolean popular;
}
