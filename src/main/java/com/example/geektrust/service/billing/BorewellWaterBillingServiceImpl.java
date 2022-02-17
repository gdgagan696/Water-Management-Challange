package com.example.geektrust.service.billing;

public class BorewellWaterBillingServiceImpl implements WaterBillingService {
    private static final double PRICE_PER_LITRE = 1.5d;

    @Override
    public double getTotalAmount(double consumedWater) {
        return consumedWater * PRICE_PER_LITRE;
    }
}
