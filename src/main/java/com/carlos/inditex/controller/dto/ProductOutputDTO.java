package com.carlos.inditex.controller.dto;

import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value(staticConstructor = "of")
public class ProductOutputDTO {
    long productId;
    int brandId;
    int priceList;
    LocalDateTime startDate;
    LocalDateTime endDate;
    BigDecimal price;
}
