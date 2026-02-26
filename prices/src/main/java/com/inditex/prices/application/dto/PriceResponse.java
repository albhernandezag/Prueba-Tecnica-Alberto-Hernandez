package com.inditex.prices.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PriceResponse(
        Long productId,
        Integer brandId,
        Integer priceList,
        @JsonFormat(pattern = "yyyy-MM-dd-HH.mm.ss") 
        LocalDateTime startDate,
        @JsonFormat(pattern = "yyyy-MM-dd-HH.mm.ss") 
        LocalDateTime endDate,
        BigDecimal price
) {}
