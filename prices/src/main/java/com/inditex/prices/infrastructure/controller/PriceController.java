package com.inditex.prices.infrastructure.controller;

import com.inditex.prices.application.dto.PriceResponse;
import com.inditex.prices.application.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prices")
public class PriceController {

    private final PriceService priceService;

    @GetMapping
    public ResponseEntity<PriceResponse> getPrice(
            @RequestParam Integer brandId,
            @RequestParam Long productId,
            @RequestParam
            @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
            LocalDateTime applicationDate) {

        PriceResponse response = priceService.findApplicablePrice(brandId, productId, applicationDate);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }
}
