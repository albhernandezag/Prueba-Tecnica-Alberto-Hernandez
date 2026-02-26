package com.inditex.prices.application.service;

import com.inditex.prices.application.dto.PriceResponse;
import com.inditex.prices.domain.model.Price;
import org.springframework.stereotype.Service;
import com.inditex.prices.infrastructure.repository.PriceRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PriceService {

    private final PriceRepository priceRepository;

    public PriceResponse findApplicablePrice(Integer brandId, Long productId, LocalDateTime applicationDate) {
        return priceRepository.findApplicablePrices(brandId, productId, applicationDate)
                .stream()
                .findFirst()
                .map(price -> this.toResponse(price))
                .orElse(null);
    }
    
    private PriceResponse toResponse(Price price) {
        return new PriceResponse(
                price.getProductId(),
                price.getBrandId(),
                price.getPriceList(),
                price.getStartDate(),
                price.getEndDate(),
                price.getPrice()
        );
    }
}
