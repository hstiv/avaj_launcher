package com.hstiv.avaj_launcher;

import com.hstiv.application.Tower;
import com.hstiv.application.Coordinates;
import com.hstiv.application.WeatherProvider;
import java.lang.*;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        this.conditionsChanged();
    }
}
