package com.hstiv.avaj.wehicle;

import javax.management.BadAttributeValueExpException;
import java.lang.*;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws Exception {

        Coordinates coordinates = new Coordinates(longitude, latitude, (Math.min(height, 100)));

        if (longitude < 0 || latitude < 0 || height < 0) {
            throw new BadAttributeValueExpException(coordinates);
        }

        switch (type.toLowerCase()) {
            case "helicopter":
                return new Helicopter(name, coordinates);
            case "jetplane":
                return new JetPlane(name, coordinates);
            case "baloon":
                return new Baloon(name, coordinates);
            default:
                System.out.println("AircraftFactory: Wrong Aircraft type=" + type);
                break;
        }
        return null;
    }
}
