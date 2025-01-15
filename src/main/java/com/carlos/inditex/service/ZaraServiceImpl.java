package com.carlos.inditex.service;

import com.carlos.inditex.domain.Product;
import com.carlos.inditex.exception.ProductNotFoundException;
import com.carlos.inditex.repository.ProductRepository;
import com.carlos.inditex.repository.mapper.ProductModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ZaraServiceImpl implements ZaraService {

    private final ProductRepository productRepository;
    private final ProductModelMapper productModelMapper;

    @Override
    public Product getProductForDate(int brandId, int productId, LocalDateTime date) {
        var product = productRepository.findPriceListForBrandProductAndDates(brandId, productId, date)
                .stream()
                .map(productModelMapper::mapProductMO)
                .findFirst();
        if (product.isPresent())
            return product.get();
        else
            throw new ProductNotFoundException();
    }
}
