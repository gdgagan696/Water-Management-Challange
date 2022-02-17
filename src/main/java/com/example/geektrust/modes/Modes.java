package com.example.geektrust.modes;

import com.example.geektrust.commands.CommandExecutor;
import com.example.geektrust.commands.CommandFactory;
import com.example.geektrust.model.CoammandDto;

import java.io.IOException;

public abstract class Modes {

    private CommandFactory commandFactory;

    public Modes(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public abstract void processInput() throws IOException;

    protected void processCommand(CoammandDto coammandDto) {
        CommandExecutor commandExecutor = commandFactory.getCommandExecutor(coammandDto);
        commandExecutor.execute(coammandDto);
    }
}
