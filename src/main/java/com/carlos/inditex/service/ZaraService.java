package com.carlos.inditex.service;

import com.carlos.inditex.domain.Product;

import java.time.LocalDateTime;

public interface ZaraService {
    Product getProductForDate(LocalDateTime date, int productId, int brandId);
}
