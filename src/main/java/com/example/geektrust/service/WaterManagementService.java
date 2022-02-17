package com.example.geektrust.service;

import com.example.geektrust.model.ApartmentInfo;
import com.example.geektrust.model.BillingInfo;
import com.example.geektrust.exceptions.InValidOperationException;
import com.example.geektrust.service.billing.BorewellWaterBillingServiceImpl;
import com.example.geektrust.service.billing.CorporationWaterBillingServiceImpl;
import com.example.geektrust.service.billing.TankerWaterBillingServiceImpl;

import java.util.Objects;

public class WaterManagementService {
    private ApartmentInfo apartmentInfo;
    private CorporationWaterBillingServiceImpl corporationWaterBillingService;
    private BorewellWaterBillingServiceImpl borewellWaterBillingService;
    private TankerWaterBillingServiceImpl tankerWaterBillingService;

    public WaterManagementService(CorporationWaterBillingServiceImpl corporationWaterBillingService,
                                  BorewellWaterBillingServiceImpl borewellWaterBillingService) {
        this.corporationWaterBillingService = corporationWaterBillingService;
        this.borewellWaterBillingService = borewellWaterBillingService;
    }

    public void setOptionalDependencies() {
        if (Objects.isNull(tankerWaterBillingService)) {
            tankerWaterBillingService = new TankerWaterBillingServiceImpl();
        }
    }

    public ApartmentInfo createAppartment(ApartmentInfo apartmentInfo) {
        if (this.apartmentInfo != null) {
            throw new InValidOperationException("You can initialise apartment only once");
        }
        this.apartmentInfo = apartmentInfo;
        return this.apartmentInfo;

    }

    public void addGuests(int guests) {
        apartmentInfo.addGuests(guests);
    }

    public void calculateBill() {
        BillingInfo billingInfo = apartmentInfo.getBillingInfo();
        int daysInAMonth = billingInfo.getDaysInAMonth();
        int waterConsumptionPerPerson = apartmentInfo.getWaterConsumptionPerPerson();
        double totalWater = apartmentInfo.getApartmentType().getPersons() * waterConsumptionPerPerson * daysInAMonth;

        int totalRatio = billingInfo.getCorporationRatio() + billingInfo.getBoreWellRatio();

        double corporationWater = (billingInfo.getCorporationRatio() * totalWater) / (totalRatio * 1.0);

        double boreWellWater = totalWater - corporationWater;
        double totalBill = corporationWaterBillingService.getTotalAmount(corporationWater) + borewellWaterBillingService.getTotalAmount(boreWellWater);
        double totalWaterConsumedByGuests = apartmentInfo.getTotalGuests() * waterConsumptionPerPerson * daysInAMonth;
        if (totalWaterConsumedByGuests > 0.0) {
            this.setOptionalDependencies();
            totalBill += tankerWaterBillingService.getTotalAmount(totalWaterConsumedByGuests);
        }
        double totalWaterConsumed = totalWater + totalWaterConsumedByGuests;
        totalBill = Math.ceil(totalBill);
        System.out.println((int) totalWaterConsumed + " " + (int) totalBill);
    }

}
