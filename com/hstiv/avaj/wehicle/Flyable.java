package com.hstiv.avaj.wehicle;

import com.hstiv.avaj.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}