package com.example.geektrust.commands;

import com.example.geektrust.exceptions.InvalidCommandException;
import com.example.geektrust.model.ApartmentInfo;
import com.example.geektrust.model.CoammandDto;
import com.example.geektrust.service.WaterManagementService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class CreateApartmentCommandTest {

    @InjectMocks
    private CreateApartmentCommand createApartmentCommand;

    @Mock
    private WaterManagementService waterManagementService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateApartment() {
        CoammandDto coammandDto = new CoammandDto("ALLOT_WATER 2 3:7");
        Mockito.when(waterManagementService.createAppartment(Mockito.any(ApartmentInfo.class)))
                .thenReturn(new ApartmentInfo());
        createApartmentCommand.execute(coammandDto);
        Mockito.verify(waterManagementService).createAppartment(Mockito.any(ApartmentInfo.class));
    }

    @Test
    public void testCreateApartment_ThrowsException() {
        CoammandDto coammandDto = new CoammandDto("ALLOT_WATER 2 3:7:1");
        InvalidCommandException exception = Assertions.assertThrows(InvalidCommandException.class, () -> {
            createApartmentCommand.execute(coammandDto);
        });
        Mockito.verifyZeroInteractions(waterManagementService);
    }
}