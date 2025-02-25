package com.carlos.inditex.controller.mapper;

import com.carlos.inditex.domain.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductMapperTest {

    ProductMapper productMapper = new ProductMapper();

    @Test
    void shouldReturnProductOutput() {
        var startDate = LocalDateTime.now();
        var endDate = startDate.plusDays(1);
        var price = new BigDecimal("5.00");
        var product = new Product(2, startDate, endDate, 3, 1L, 4, price, "EUR");

        var productOutput = productMapper.mapProductToProductOutputDTO(product);

        assertEquals(1L, productOutput.getProductId());
        assertEquals(2, productOutput.getBrandId());
        assertEquals(3, productOutput.getPriceList());
        assertEquals(startDate, productOutput.getStartDate());
        assertEquals(endDate, productOutput.getEndDate());
        assertEquals(price, productOutput.getPrice());
    }
}