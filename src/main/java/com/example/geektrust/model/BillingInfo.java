package com.example.geektrust.model;

import java.util.Objects;

public class BillingInfo {
    private Integer corporationRatio;
    private Integer boreWellRatio;
    private int daysInAMonth;

    public int getCorporationRatio() {
        return corporationRatio;
    }

    public void setCorporationRatio(int corporationRatio) {
        this.corporationRatio = corporationRatio;
    }

    public int getBoreWellRatio() {
        return boreWellRatio;
    }

    public void setBoreWellRatio(int boreWellRatio) {
        this.boreWellRatio = boreWellRatio;
    }

    public int getDaysInAMonth() {
        return daysInAMonth;
    }

    public void setDaysInAMonth(int daysInAMonth) {
        this.daysInAMonth = daysInAMonth;
    }

    public boolean isWaterRatioInitializes(){
        return Objects.nonNull(corporationRatio) && Objects.nonNull(boreWellRatio);
    }
}
