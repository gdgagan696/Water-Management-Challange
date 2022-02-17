package com.example.geektrust.commands;

import com.example.geektrust.model.CoammandDto;
import com.example.geektrust.exceptions.InvalidCommandException;
import com.example.geektrust.service.WaterManagementService;

public class CalculateBillCommand extends CommandExecutor {

    public CalculateBillCommand(WaterManagementService waterManagementService) {
        super(waterManagementService);
    }

    @Override
    public void execute(CoammandDto coammandDto) {
        if (!validateCommand(coammandDto)) {
            throw new InvalidCommandException("Please check your bill command");
        }
        waterManagementService.calculateBill();
    }

    @Override
    public boolean validateCommand(CoammandDto coammandDto) {
        return coammandDto.getParams().size() == 0;
    }
}
