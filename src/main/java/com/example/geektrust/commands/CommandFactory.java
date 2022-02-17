package com.example.geektrust.commands;

import com.example.geektrust.model.CoammandDto;
import com.example.geektrust.exceptions.InvalidCommandException;
import com.example.geektrust.service.WaterManagementService;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private Map<String, CommandExecutor> commands = new HashMap<>();

    public CommandFactory(WaterManagementService waterManagementService) {
        commands.put("ALLOT_WATER", new CreateApartmentCommand(waterManagementService));
        commands.put("ADD_GUESTS", new AddGuestsCommand(waterManagementService));
        commands.put("BILL", new CalculateBillCommand(waterManagementService));
    }

    public CommandExecutor getCommandExecutor(final CoammandDto coammandDto) {
        final CommandExecutor commandExecutor = commands.get(coammandDto.getCommandName());
        if (commandExecutor == null) {
            throw new InvalidCommandException("Invalid Command,Please check your command");
        }
        return commandExecutor;
    }
}
