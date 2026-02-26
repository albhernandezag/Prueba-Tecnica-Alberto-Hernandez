package com.inditex.prices.infrastructure.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final String baseUrl = "/prices?brandId=1&productId=35455&applicationDate=";

    @Test
    void test1_price_day_14_at_10() throws Exception {
        mockMvc.perform(get(baseUrl + "2020-06-14-10.00.00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.price").value(35.50));
    }

    @Test
    void test2_price_day_14_at_16() throws Exception {
        mockMvc.perform(get(baseUrl + "2020-06-14-16.00.00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(2))
                .andExpect(jsonPath("$.price").value(25.45));
    }

    @Test
    void test3_price_day_14_at_21() throws Exception {
        mockMvc.perform(get(baseUrl + "2020-06-14-21.00.00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.price").value(35.50));
    }

    @Test
    void test4_price_day_15_at_10() throws Exception {
        mockMvc.perform(get(baseUrl + "2020-06-15-10.00.00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(3))
                .andExpect(jsonPath("$.price").value(30.50));
    }

    @Test
    void test5_price_day_16_at_21() throws Exception {
        mockMvc.perform(get(baseUrl + "2020-06-16-21.00.00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(4))
                .andExpect(jsonPath("$.price").value(38.95));
    }
}
