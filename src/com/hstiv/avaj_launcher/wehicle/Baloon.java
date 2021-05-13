package com.hstiv.avaj_launcher.wehicle;

import com.hstiv.avaj_launcher.WeatherTower;
import java.lang.*;

public class Baloon  extends Aircraft implements Flyable {
    private WeatherTower weatherTower;


    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
        System.out.println("Baloon@" + name + " has been created.");
    }
    private void updateCoordinates(String weather) {

        if (weather.equals("SUN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(),  this.coordinates.getHeight() + 4);
            System.out.println("Baloon#" + this.name + "(" + this.id + "): Let's enjoy the good weather and take some pics.");
        }
        else if (weather.equals("RAIN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 5);
            if (this.coordinates.getHeight() != 0)
                System.out.println("Baloon#" + this.name + "(" + this.id + "): Oh, Zeus must must be fury of Hermes again.");
        }
        else if (weather.equals("FOG")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
            if (this.coordinates.getHeight() != 0)
                System.out.println("Baloon#" + this.name + "(" + this.id + "): Tartarus gates are open. Be ready for Titanomachy.");
        }
        else if (weather.equals("SNOW")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
            if (this.coordinates.getHeight() != 0)
                System.out.println("Baloon#" + this.name + "(" + this.id + "): Just winter, huh?");
        }
        if (this.coordinates.getHeight() > 100)
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), 100);
    }

    @Override
    public void updateConditions() {
        this.updateCoordinates(this.weatherTower.getWeather(this.coordinates));

        if (this.coordinates.getHeight() <= 0) {
            System.out.println("Baloon#" + this.name + "(" + this.id + "): Landing... Coordinates:" +
                    " lo: " + this.coordinates.getLongitude() +
                    " la: " + this.coordinates.getLatitude() +
                    " h: 0"
            );
            this.weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Tower says: The Baloon#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}
