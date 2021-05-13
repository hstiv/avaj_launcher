package com.hstiv.avaj;

import com.hstiv.avaj.wehicle.Coordinates;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        this.conditionsChanged();
    }
}
