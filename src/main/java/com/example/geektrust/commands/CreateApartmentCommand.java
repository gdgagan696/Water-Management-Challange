package com.example.geektrust.commands;

import com.example.geektrust.constants.ApartmentType;
import com.example.geektrust.model.ApartmentInfo;
import com.example.geektrust.model.BillingInfo;
import com.example.geektrust.model.CoammandDto;
import com.example.geektrust.exceptions.InvalidCommandException;
import com.example.geektrust.service.WaterManagementService;

public class CreateApartmentCommand extends CommandExecutor {

    private static int NO_OF_DAYS_IN_A_MONTH = 30;
    private static int WATER_CONSUMPTION_PER_PERSON = 10;

    public CreateApartmentCommand(WaterManagementService waterManagementService) {
        super(waterManagementService);
    }

    @Override
    public void execute(CoammandDto coammandDto) {
        if (!validateCommand(coammandDto)) {
            throw new InvalidCommandException("Please check your create apartment command");
        }

        ApartmentInfo apartmentInfo = new ApartmentInfo();

        BillingInfo billingInfo = new BillingInfo();
        billingInfo.setCorporationRatio(Integer.parseInt(coammandDto.getParams().get(1).charAt(0) + ""));
        billingInfo.setBoreWellRatio(Integer.parseInt(coammandDto.getParams().get(1).charAt(2) + ""));
        billingInfo.setDaysInAMonth(NO_OF_DAYS_IN_A_MONTH);

        apartmentInfo.setApartmentType(ApartmentType.getAppartmentType(Integer.parseInt(coammandDto.getParams().get(0))));
        apartmentInfo.setWaterConsumptionPerPerson(WATER_CONSUMPTION_PER_PERSON);
        apartmentInfo.setBillingInfo(billingInfo);

        waterManagementService.createAppartment(apartmentInfo);
    }

    @Override
    public boolean validateCommand(CoammandDto coammandDto) {
        return coammandDto.getParams().size() == 2 && coammandDto.getParams().get(1).split(":").length == 2;
    }
}
