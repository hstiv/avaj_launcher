package com.hstiv.avaj;

import com.hstiv.avaj.wehicle.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String weather[] = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() { }

    public String getCurrentWeather(Coordinates coordinates) {
        int tmp = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
        return weather[tmp % 4];
    }

    public static WeatherProvider getProvider() {
        return WeatherProvider.weatherProvider;
    }

}
