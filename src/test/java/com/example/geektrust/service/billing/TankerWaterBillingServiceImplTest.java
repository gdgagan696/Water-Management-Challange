package com.example.geektrust.service.billing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class TankerWaterBillingServiceImplTest {

    @InjectMocks
    private TankerWaterBillingServiceImpl tankerWaterBillingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks( this );
    }

    @Test
    public void testgetTotalAmount() {
        Assertions.assertEquals(13100.0,tankerWaterBillingService.getTotalAmount(3200));
    }
}