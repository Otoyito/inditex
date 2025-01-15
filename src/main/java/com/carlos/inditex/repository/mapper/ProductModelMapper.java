package com.carlos.inditex.repository.mapper;

import com.carlos.inditex.domain.Product;
import com.carlos.inditex.model.ProductMO;
import org.springframework.stereotype.Component;

@Component
public class ProductModelMapper {

    public Product mapProductMO(ProductMO productMO) {
        return new Product(productMO.getProductId().getBrandId(), productMO.getStartDate(), productMO.getEndDate(), productMO.getProductId().getPriceList(), productMO.getProductId().getProductId(), productMO.getPriority(), productMO.getPrice(), productMO.getCurr());
    }
}
