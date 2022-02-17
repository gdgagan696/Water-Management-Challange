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

class CalculateBillCommandTest {

    @InjectMocks
    private CalculateBillCommand calculateBillCommand;

    @Mock
    private WaterManagementService waterManagementService;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks( this );
    }

    @Test
    public void testCalculateBill() {
        CoammandDto coammandDto = new CoammandDto("BILL");
        Mockito.doNothing().when(waterManagementService).calculateBill();
        calculateBillCommand.execute(coammandDto);
        Mockito.verify(waterManagementService).calculateBill();
    }
    @Test
    public void testCalculateBill_ThrowsException() {
        CoammandDto coammandDto = new CoammandDto("BILL 3");
        InvalidCommandException exception = Assertions.assertThrows(InvalidCommandException.class, () -> {
            calculateBillCommand.execute(coammandDto);
        });
        Mockito.verifyZeroInteractions(waterManagementService);
    }
}