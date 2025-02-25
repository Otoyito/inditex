package com.carlos.inditex.repository.mapper;

import com.carlos.inditex.model.ProductMO;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ProductModelMapperTest {

    ProductModelMapper productModelMapper = new ProductModelMapper();

    @Test
    void shouldReturnProductBO() {
        var productId = new ProductMO.ProductId();
        productId.setProductId(1L);
        productId.setBrandId(2);
        productId.setPriceList(0);
        var startDate = LocalDateTime.now();
        var endDate = LocalDateTime.now().plusDays(1);
        var price = new BigDecimal("5.00");
        var productMO = new ProductMO();
        productMO.setProductId(productId);
        productMO.setStartDate(startDate);
        productMO.setEndDate(endDate);
        productMO.setPriority(1);
        productMO.setPrice(price);
        productMO.setCurr("EUR");

        var product = productModelMapper.mapProductMO(productMO);

        assertEquals(2, product.getBrandId());
        assertEquals(startDate, product.getStartDate());
        assertEquals(endDate, product.getEndDate());
        assertEquals(0, product.getPriceList());
        assertEquals(1L, product.getProductId());
        assertEquals(1, product.getPriority());
        assertEquals(price, product.getPrice());
        assertEquals("EUR", product.getCurr());
    }
}