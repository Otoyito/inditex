package com.carlos.inditex.service;

import com.carlos.inditex.domain.Product;

import java.time.LocalDateTime;

public interface ZaraService {
    Product getProductForDate(int brandId, int productId, LocalDateTime date);
}
