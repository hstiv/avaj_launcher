package com.hstiv.avaj_launcher.wehicle;

import com.hstiv.application.Coordinates;
import com.hstiv.application.Flyable;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws Exception {

        Coordinates coordinates = new Coordinates(longitude, latitude, (height > 100 ? height : 100));

        if (longitude < 0 || latitude < 0 || height < 0) {
            throw new BadAttributeValueExpException(coordinates);
        }

        if (type.toLowerCase().equals("helicopter"))
            return new Helicopter(name, coordinates);
        else if (type.toLowerCase.equals("jetplane"))
            return new JetPlane(name, coordinates);
        else if (type.toLowerCase.equals("baloon"))
            return new Baloon(name, coordinates);
        else {
            LocalDateTime now = LocalDateTime.now();
            System.out.println("AircraftFactory: Wrong Aircraft type=" + type);
        }
        return null;
    }
}
