package com.hstiv.avaj;

import java.util.Arrays;
import java.io.*;
import java.lang.*;
import com.hstiv.avaj.WeatherTower;
import com.hstiv.avaj.wehicle.AircraftFactory;

public class Simulator {

    private static BufferedReader br;  //creates a buffering character input stream
    private static int cycles;
    private static WeatherTower weatherTower;

    private static void aircraftLauncher() throws Exception {
        String line;
        String[] sval;
        ArrayList<String> ids = new ArrayList<String>();

        try {
            while ((line = br.readLine()) != null) {
                
				sval = line.split(" ");
                
				if (!ids.isEmpty) {
					for (int i = 0; i < ids.size(); i++) {
						if (ids[i].equals(sval[1]))
							throw new Exception("(" + sval[1] + ") is unique ID!");
					}
                }
                
				AircraftFactory.newAircraft(
                        sval[0],
                        sval[1],
                        Integer.parseInt(sval[2]),
                        Integer.parseInt(sval[3]),
                        Integer.parseInt(sval[4]))
                        .registerTower(weatherTower);
                
				ids.add(sval[1]);
            }
        } catch (Exception e) {
            throw e;
        }
        br.close();
    }

    public static void main(String[] args) throws Exception {

        String line;

        try {
            File file = new File(args[0]);
            if (!file.exists() || !file.canRead()) {
                throw new FileNotFoundException(file.toString());
            }
            br = new BufferedReader(new FileReader(file));  //creates a buffering character input stream

            weatherTower = new WeatherTower();
            cycles = Integer.parseInt(br.readLine());
            aircraftLauncher();
            for (int i = 0; i < cycles; i++) {
                try{
                    weatherTower.changeWeather();
                } catch (Exception e) {
                    System.out.println("Error");
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("need input file!");
        }
    }
}