package com.carlos.inditex.repository;

import com.carlos.inditex.model.ProductMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<ProductMO, Long> {

    @Query(value =
            "        SELECT brand_id, product_id, price_list, start_date, end_date, priority, price, curr" +
                    "  FROM products " +
                    " WHERE brand_id = ?1 " +
                    "   AND product_id = ?2 " +
                    "   AND start_date <= ?3 " +
                    "   AND end_date >= ?3 " +
                    "ORDER BY priority DESC",
            nativeQuery = true)
    List<ProductMO> findPriceListForBrandProductAndDates(int brandId, int productId, LocalDateTime date);
}
