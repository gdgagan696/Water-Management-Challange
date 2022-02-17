package com.example.geektrust.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoammandDto {
    private static final String SPACE = " ";
    private String commandName;
    private List<String> params;

    public CoammandDto(String inputCommand) {
        List<String> tokenizeCommand = Arrays.stream(inputCommand.trim().split(SPACE))
                .map(String::trim)
                .filter(token -> (token.length() > 0)).collect(Collectors.toList());
        commandName = tokenizeCommand.get(0);
        tokenizeCommand.remove(0);
        params = tokenizeCommand;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }
}
