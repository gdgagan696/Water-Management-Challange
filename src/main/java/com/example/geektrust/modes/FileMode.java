package com.example.geektrust.modes;

import com.example.geektrust.commands.CommandFactory;
import com.example.geektrust.model.CoammandDto;

import java.io.*;

public class FileMode extends Modes {

    private String filePath;

    public FileMode(CommandFactory commandFactory, String filePath) {
        super(commandFactory);
        this.filePath = filePath;
    }

    @Override
    public void processInput() throws IOException {
        File file = new File(filePath);
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new FileNotFoundException("File Not found");
        }

        String input = reader.readLine();
        while (input != null) {
            CoammandDto command = new CoammandDto(input);
            processCommand(command);
            if (input.equals("BILL")) break;
            input = reader.readLine();
        }
    }
}
