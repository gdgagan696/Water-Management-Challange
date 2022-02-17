package com.example.geektrust;

import com.example.geektrust.commands.CommandFactory;
import com.example.geektrust.exceptions.InvalidCommandException;
import com.example.geektrust.modes.FileMode;
import com.example.geektrust.service.WaterManagementService;
import com.example.geektrust.service.billing.BorewellWaterBillingServiceImpl;
import com.example.geektrust.service.billing.CorporationWaterBillingServiceImpl;

import java.io.IOException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        if (!isValidArguments(args)) {
            throw new InvalidCommandException("Please verify your command srguments");
        }
        WaterManagementService waterManagementService = new WaterManagementService(new CorporationWaterBillingServiceImpl(), new BorewellWaterBillingServiceImpl());
        CommandFactory commandFactory = new CommandFactory(waterManagementService);
        FileMode fileMode = new FileMode(commandFactory, args[0]);
        fileMode.processInput();
    }

    private static boolean isValidArguments(String[] args) {
        return Objects.nonNull(args) && args.length == 1;
    }
}
