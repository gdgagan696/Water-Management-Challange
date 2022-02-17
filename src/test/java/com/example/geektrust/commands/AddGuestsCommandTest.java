package com.example.geektrust.commands;

import com.example.geektrust.exceptions.InvalidCommandException;
import com.example.geektrust.model.CoammandDto;
import com.example.geektrust.service.WaterManagementService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class AddGuestsCommandTest {

    @InjectMocks
    private AddGuestsCommand addGuestsCommand;

    @Mock
    private WaterManagementService waterManagementService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks( this );
    }

    @Test
    public void testAddGuests() {
        CoammandDto coammandDto = new CoammandDto("ADD_GUESTS 3");
        Mockito.doNothing().when(waterManagementService).addGuests(3);
        addGuestsCommand.execute(coammandDto);
        Mockito.verify(waterManagementService).addGuests(3);
    }
    @Test
    public void testAddGuests_ThrowsException() {
        CoammandDto coammandDto = new CoammandDto("ADD_GUESTS 3 3");
        InvalidCommandException exception = Assertions.assertThrows(InvalidCommandException.class, () -> {
            addGuestsCommand.execute(coammandDto);
        });
        Mockito.verifyZeroInteractions(waterManagementService);
    }
}