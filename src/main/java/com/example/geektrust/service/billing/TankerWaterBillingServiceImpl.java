package com.example.geektrust.service.billing;

import java.util.Map;
import java.util.TreeMap;

public class TankerWaterBillingServiceImpl implements WaterBillingService {
    private static final Map<Integer, Double> maxUptoBillRate = new TreeMap<>();

    static {
        maxUptoBillRate.put(500, 2.0);
        maxUptoBillRate.put(1500, 3.0);
        maxUptoBillRate.put(3000, 5.0);
        maxUptoBillRate.put(Integer.MAX_VALUE, 8.0);
    }

    @Override
    public double getTotalAmount(double consumedWater) {
        double totalTankerWaterBill = 0;
        int prevSlabLimit = 0;
        for (Map.Entry<Integer, Double> entry : maxUptoBillRate.entrySet()) {
            int slab = entry.getKey();
            int slabDiff = slab - prevSlabLimit;
            double slabRate = entry.getValue();
            if (consumedWater > slabDiff) {
                consumedWater -= slabDiff;
                totalTankerWaterBill += slabDiff * slabRate;
            } else {
                totalTankerWaterBill += consumedWater * slabRate;
                consumedWater = 0;
            }
            prevSlabLimit = slab;
        }
        return totalTankerWaterBill;
    }
}
