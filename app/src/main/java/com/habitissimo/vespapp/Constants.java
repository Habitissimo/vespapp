package com.habitissimo.vespapp;

import android.text.TextUtils;

public class Constants {
    public static final String API_BASE_URL = "http://web-1.avispamientoweb.4404a270.cont.dockerapp.io/";

    public static boolean isBaseApiUrlDefined() {
        return !TextUtils.isEmpty(API_BASE_URL);
    }
}
