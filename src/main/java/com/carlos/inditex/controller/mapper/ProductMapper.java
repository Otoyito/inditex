package com.carlos.inditex.controller.mapper;

import com.carlos.inditex.controller.dto.ProductOutputDTO;
import com.carlos.inditex.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductOutputDTO mapProductToProductOutputDTO(Product product) {
        // Given the simplicity... might be a bit overengineered :P
        return ProductOutputDTO.of(
                product.getProductId(),
                product.getBrandId(),
                product.getPriceList(),
                product.getStartDate(),
                product.getEndDate(),
                product.getPrice());
    }
}
