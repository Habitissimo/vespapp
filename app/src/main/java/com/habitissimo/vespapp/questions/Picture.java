package com.habitissimo.vespapp.questions;

/**
 * Created by archi on 11/03/16.
 */
public class Picture {
    public String file;
    public Sighting sighting;

    public Picture() {
    }

    public Picture(String file, Sighting sighting) {
        this.file = file;
        this.sighting = sighting;
    }
}
