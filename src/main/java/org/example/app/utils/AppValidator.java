package org.example.app.utils;

import org.example.app.exceptions.TemperatureException;

public class AppValidator {

    public final static int LOWER_TEMPERATURE = -10;
    public final static int HIGHER_TEMPERATURE = 35;


    public String validateTemperature(int temperature) throws TemperatureException {
        if (temperature < LOWER_TEMPERATURE || temperature > HIGHER_TEMPERATURE) {
            throw new TemperatureException("Inability to operate the device!");
        } else return "The device is working, the temperature is acceptable";

    }
}
