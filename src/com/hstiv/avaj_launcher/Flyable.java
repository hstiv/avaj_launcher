package com.hstiv.avaj_launcher;

import com.hstiv.application.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}