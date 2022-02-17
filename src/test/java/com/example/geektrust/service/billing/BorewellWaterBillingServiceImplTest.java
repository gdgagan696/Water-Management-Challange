package com.example.geektrust.service.billing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class BorewellWaterBillingServiceImplTest {

    @InjectMocks
    private BorewellWaterBillingServiceImpl borewellWaterBillingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks( this );
    }

    @Test
    public void testgetTotalAmount() {
        Assertions.assertEquals(3.0,borewellWaterBillingService.getTotalAmount(2.0));
    }
}