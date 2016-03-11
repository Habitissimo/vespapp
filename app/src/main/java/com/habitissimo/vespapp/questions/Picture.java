package com.habitissimo.vespapp.questions;

import java.util.Date;

/**
 * Created by archi on 11/03/16.
 */
public class Picture {
    public Sighting sighting;
    public Date created_at;
    public Date updated_at;

    public Picture(Sighting sighting, Date created_at, Date updated_at) {
        this.sighting = sighting;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
