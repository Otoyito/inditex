package com.carlos.inditex.service;

import com.carlos.inditex.domain.Product;
import com.carlos.inditex.exception.ProductNotFoundException;
import com.carlos.inditex.repository.ProductRepository;
import com.carlos.inditex.repository.mapper.ProductModelMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class ZaraServiceImpl implements ZaraService {

    private final ProductRepository productRepository;
    private final ProductModelMapper productModelMapper;

    @Override
    public Product getProductForDate(LocalDateTime date, int productId, int brandId) {
        try {
            var product = productRepository.findPriceListForBrandProductAndDates(brandId, productId, date)
                    .stream()
                    .map(productModelMapper::mapProductMO)
                    .findFirst();
            if(product.isPresent())
                return product.get();
            else {
                log.error(String.format("No product found for brand: %d, product: %d, date: %s", brandId, productId, date));
                throw new ProductNotFoundException();
            }
        }
        catch(Exception e) {
            if(!(e instanceof ProductNotFoundException))
                log.error(String.format("Unexpected error getting brand: %d, product: %d, date: %s", brandId, productId, date), e);
            throw e;
        }
    }
}
