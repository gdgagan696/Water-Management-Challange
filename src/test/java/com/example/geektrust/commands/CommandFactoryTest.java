package com.example.geektrust.commands;

import com.example.geektrust.exceptions.InvalidCommandException;
import com.example.geektrust.model.CoammandDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class CommandFactoryTest {

    @InjectMocks
    private CommandFactory commandFactory;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks( this );
    }
    @Test
    void testGetCommandExecutor() {
        CoammandDto coammandDto=new CoammandDto("BILL");
        CommandExecutor commandExecutor=commandFactory.getCommandExecutor(coammandDto);
        Assertions.assertTrue(commandExecutor instanceof  CalculateBillCommand);
    }
    @Test
    public void testGetCommandExecutor_ThrowsException() {
        CoammandDto coammandDto=new CoammandDto("BILLL");
        InvalidCommandException exception = Assertions.assertThrows(InvalidCommandException.class, () -> {
            commandFactory.getCommandExecutor(coammandDto);
        });
        Assertions.assertTrue(exception.getMessage().contains("Invalid"));
    }

}