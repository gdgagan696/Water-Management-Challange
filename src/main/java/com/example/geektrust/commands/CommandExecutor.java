package com.example.geektrust.commands;

import com.example.geektrust.model.CoammandDto;
import com.example.geektrust.service.WaterManagementService;

public abstract class CommandExecutor {
    WaterManagementService waterManagementService;

    public CommandExecutor(final WaterManagementService waterManagementService) {
        this.waterManagementService = waterManagementService;
    }

    public abstract void execute(CoammandDto coammandDto);

    public abstract boolean validateCommand(CoammandDto coammandDto);

}
