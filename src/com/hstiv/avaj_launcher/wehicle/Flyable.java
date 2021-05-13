package com.hstiv.avaj_launcher.wehicle;

import com.hstiv.avaj_launcher.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}