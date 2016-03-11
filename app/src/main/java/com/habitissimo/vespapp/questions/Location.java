package com.habitissimo.vespapp.questions;

import java.util.Date;

/**
 * Created by archi on 11/03/16.
 */
public class Location {

    private String name;
    private float lat;
    private float lng;
    private Date created_at;
    private Date updated_at;

    public Location(String n, float alat, float alng, Date c, Date u) {
        this.name = n;
        this.lat = alat;
        this.lat = alng;
        this.lng = alng;
        this.created_at = c;
        this.updated_at = u;

    }

}
