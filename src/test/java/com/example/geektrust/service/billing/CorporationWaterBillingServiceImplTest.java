package com.example.geektrust.service.billing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class CorporationWaterBillingServiceImplTest {

    @InjectMocks
    private CorporationWaterBillingServiceImpl corporationWaterBillingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks( this );
    }

    @Test
    public void testgetTotalAmount() {
        Assertions.assertEquals(2.0,corporationWaterBillingService.getTotalAmount(2.0));
    }
}