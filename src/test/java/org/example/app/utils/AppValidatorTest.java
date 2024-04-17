package org.example.app.utils;

import org.example.app.exceptions.TemperatureException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AppValidatorTest {

    AppValidator validator;

    @BeforeEach
    void setUp() {
        validator = new AppValidator();
    }


    @Test
    @DisplayName("Test if temperature is in bounds.")
    void test_If_Temperature_Is_In_Bounds() throws TemperatureException {
        assertEquals("The device is working, the temperature is acceptable",
                validator.validateTemperature(12));
    }

    @Test
    @DisplayName("Test if temperature is in bounds(the lowest allowable value).")
    void test_If_Temperature_Is_In_Bounds_Lower() throws TemperatureException {
        assertEquals("The device is working, the temperature is acceptable",
                validator.validateTemperature(-10));
    }

    @Test
    @DisplayName("Test if temperature is in bounds(the highest allowable value).")
    void test_If_Temperature_Is_In_Bounds_Higher() throws TemperatureException {
        assertEquals("The device is working, the temperature is acceptable",
                validator.validateTemperature(35));
    }


    @Test
    @DisplayName("Test if invalid temperature below the allowable range throws exception.")
    void test_If_Invalid_Temperature_Lower_Range_Throws_Exception() {
        assertThrows(TemperatureException.class, () ->
                validator.validateTemperature(-11), "No exception.");
    }

    @Test
    @DisplayName("Test if invalid temperature above the allowable range throws exception.")
    void test_If_Invalid_Temperature_Higher_Range_Throws_Exception() {
        assertThrows(TemperatureException.class, () ->
                validator.validateTemperature(36), "No exception.");
    }

    @AfterEach
    void tearDown() {
        validator = null;
    }

}