package com.inditex.prices.infrastructure.repository;


import com.inditex.prices.domain.model.Price;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;


import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query("""
        SELECT p FROM Price p
        WHERE p.brandId = :brandId
          AND p.productId = :productId
          AND :applicationDate BETWEEN p.startDate AND p.endDate
        ORDER BY p.priority DESC, p.priceList DESC
    """)
    List<Price> findApplicablePrices(
            @Param("brandId") Integer brandId,
            @Param("productId") Long productId,
            @Param("applicationDate") LocalDateTime applicationDate
    );
}
