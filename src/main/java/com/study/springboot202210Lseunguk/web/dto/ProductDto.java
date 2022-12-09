package com.study.springboot202210Lseunguk.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {
    private int productCode;
    private String productName;
    private int price;
    private int stock;

}
