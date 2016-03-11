package com.habitissimo.vespapp.questions;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by archi on 11/03/16.
 */
public class Sighting {

    public Location location;
    public float lat;
    public float lng;
    public int status;
    public String free_text;
    public int type;
    public Answer answer;
    public Date created_at;
    public Date update_at;
    @SerializedName("public")
    boolean _public;


    public Sighting(Location location, float lat, float lng, int status, String free_text, int type,
                    boolean _public, Answer answer, Date created_at, Date update_at) {
        this.location = location;
        this.lat = lat;
        this.lng = lng;
        this.status = status;
        this.free_text = free_text;
        this.type = type;
        this._public = _public;
        this.answer = answer;
        this.created_at = created_at;
        this.update_at = update_at;
    }
}
