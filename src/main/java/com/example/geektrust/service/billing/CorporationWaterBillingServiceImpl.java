package com.example.geektrust.service.billing;

public class CorporationWaterBillingServiceImpl implements WaterBillingService {
    private static final double PRICE_PER_LITRE = 1.0d;

    @Override
    public double getTotalAmount(double consumedWater) {
        return consumedWater * PRICE_PER_LITRE;
    }
}
