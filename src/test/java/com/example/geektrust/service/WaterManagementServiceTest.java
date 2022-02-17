package com.example.geektrust.service;

import com.example.geektrust.commands.CreateApartmentCommand;
import com.example.geektrust.constants.ApartmentType;
import com.example.geektrust.exceptions.InvalidCommandException;
import com.example.geektrust.model.ApartmentInfo;
import com.example.geektrust.model.BillingInfo;
import com.example.geektrust.model.CoammandDto;
import com.example.geektrust.service.billing.BorewellWaterBillingServiceImpl;
import com.example.geektrust.service.billing.CorporationWaterBillingServiceImpl;
import com.example.geektrust.service.billing.TankerWaterBillingServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class WaterManagementServiceTest {

    @InjectMocks
    private WaterManagementService waterManagementService;

    @Mock
    private CorporationWaterBillingServiceImpl corporationWaterBillingService;

    @Mock
    private BorewellWaterBillingServiceImpl borewellWaterBillingService;

    @Mock
    private TankerWaterBillingServiceImpl tankerWaterBillingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSetOptionalDependencies() {
        waterManagementService.setOptionalDependencies();
        Assertions.assertNotNull(tankerWaterBillingService);
    }

    @Test
    void testCreateApartment() {
        ApartmentInfo apartmentInfo = new ApartmentInfo();
        waterManagementService.createAppartment(apartmentInfo);
        Assertions.assertNotNull(waterManagementService.getApartmentInfo());
    }

    @Test
    void testAddGuests() {
        ApartmentInfo apartmentInfo = new ApartmentInfo();
        apartmentInfo.setApartmentType(ApartmentType.THREE_BHK);
        BillingInfo billingInfo = new BillingInfo();
        billingInfo.setCorporationRatio(3);
        billingInfo.setBoreWellRatio(5);
        apartmentInfo.setBillingInfo(billingInfo);
        waterManagementService.createAppartment(apartmentInfo);
        waterManagementService.addGuests(3);
        Assertions.assertEquals(3, waterManagementService.getApartmentInfo().getTotalGuests());
    }

    @Test
    void testCalculateBill() {
        ApartmentInfo apartmentInfo = new ApartmentInfo();
        apartmentInfo.setApartmentType(ApartmentType.THREE_BHK);
        apartmentInfo.setWaterConsumptionPerPerson(10);
        BillingInfo billingInfo = new BillingInfo();
        billingInfo.setCorporationRatio(3);
        billingInfo.setBoreWellRatio(5);
        billingInfo.setDaysInAMonth(30);
        apartmentInfo.setBillingInfo(billingInfo);
        Mockito.when(corporationWaterBillingService.getTotalAmount(562.5)).thenReturn(200.0);
        Mockito.when(borewellWaterBillingService.getTotalAmount(937.5)).thenReturn(500.0);
        waterManagementService.createAppartment(apartmentInfo);
        waterManagementService.calculateBill();
    }


}