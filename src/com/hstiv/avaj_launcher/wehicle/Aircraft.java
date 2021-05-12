package com.hstiv.avaj_launcher.wehicle;

import com.hstiv.application.Coordinates;
import java.util.HashMap;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = this.nextId();
    }

    private long nextId() {
        return (Aircraft.idCounter++);
    }
}
