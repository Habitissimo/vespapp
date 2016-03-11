package com.habitissimo.vespapp.questions;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by archi on 11/03/16.
 */
public class Sighting {
    public static final int STATUS_PENDING = 0;
    public static final int STATUS_PROCESSING = 1;
    public static final int STATUS_PROCESSED = 2;
    public static final int STATUS_UNSENT = -1;

    public static final int TYPE_WASP = 0;
    public static final int TYPE_NEST = 1;

    public String id;
    public Location location;
    public float lat;
    public float lng;
    public int status = STATUS_UNSENT;
    public String free_text;
    public int type;
    public List<Answer> answer;
    @SerializedName("public")
    public boolean _public;
    public List<Picture> pictures;

    public Sighting() {
    }

    public Sighting(String id, Location location, float lat, float lng, int status, String free_text, int type, List<Answer> answer,
                    boolean _public, List<Picture> pictures) {
        this.id = id;
        this.location = location;
        this.lat = lat;
        this.lng = lng;
        this.status = status;
        this.free_text = free_text;
        this.type = type;
        this.answer = answer;
        this._public = _public;
        this.pictures = pictures;
    }
}
