package com.carlos.inditex.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="products")
@Data
public class ProductMO {

    @Embeddable
    @NoArgsConstructor
    @Data
    public static class ProductId implements Serializable {
        @Column(name = "brand_id")
        private int brandId;
        @Column(name = "product_id")
        private long productId;
        @Column(name = "price_list")
        private int priceList;
    }

    @EmbeddedId
    private ProductId productId;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name ="end_date")
    private LocalDateTime endDate;
    @Column
    private int priority;
    @Column
    private BigDecimal price;
    @Column
    private String curr;
}
