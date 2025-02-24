package com.carlos.inditex.repository;

import com.carlos.inditex.model.ProductMO;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Hidden
@Repository
public interface ProductRepository extends JpaRepository<ProductMO, Long> {

    //List<ProductMO> findPriceListForBrandProductAndDates(int brandId, int productId, Instant date);
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
