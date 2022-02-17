package com.example.geektrust.model;

import com.example.geektrust.constants.ApartmentType;
import com.example.geektrust.exceptions.InValidOperationException;

import java.util.Objects;

public class ApartmentInfo {
    private ApartmentType apartmentType;
    private int totalGuests;
    private int totalPersons;
    private int waterConsumptionPerPerson;
    private BillingInfo billingInfo;

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    public int getTotalGuests() {
        return totalGuests;
    }

    public void setTotalGuests(int totalGuests) {
        this.totalGuests = totalGuests;
    }

    public int getTotalPersons() {
        return totalPersons;
    }

    public void setTotalPersons(int totalPersons) {
        this.totalPersons = totalPersons;
    }

    public int getWaterConsumptionPerPerson() {
        return waterConsumptionPerPerson;
    }

    public void setWaterConsumptionPerPerson(int waterConsumptionPerPerson) {
        this.waterConsumptionPerPerson = waterConsumptionPerPerson;
    }

    public BillingInfo getBillingInfo() {
        return billingInfo;
    }

    public void setBillingInfo(BillingInfo billingInfo) {
        this.billingInfo = billingInfo;
    }

    public void addGuests(int guests) {
        if (!isApartmentInitilised()) {
            throw new InValidOperationException("Guests can not be added before apartment initialisation");
        }
        this.totalGuests += guests;
    }

    private boolean isApartmentInitilised() {
        return Objects.nonNull(apartmentType) && Objects.nonNull(billingInfo) && Objects.nonNull(billingInfo.isWaterRatioInitializes());
    }
}
