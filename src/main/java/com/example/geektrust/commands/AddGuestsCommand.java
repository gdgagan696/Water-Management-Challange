package com.example.geektrust.commands;

import com.example.geektrust.model.CoammandDto;
import com.example.geektrust.exceptions.InvalidCommandException;
import com.example.geektrust.service.WaterManagementService;

public class AddGuestsCommand extends CommandExecutor {

    public AddGuestsCommand(WaterManagementService waterManagementService) {
        super(waterManagementService);
    }

    @Override
    public void execute(CoammandDto coammandDto) {
        if (!validateCommand(coammandDto)) {
            throw new InvalidCommandException("Please check your guests command");
        }
        waterManagementService.addGuests(Integer.parseInt(coammandDto.getParams().get(0)));
    }

    @Override
    public boolean validateCommand(CoammandDto coammandDto) {
        return coammandDto.getParams().size() == 1;
    }
}
