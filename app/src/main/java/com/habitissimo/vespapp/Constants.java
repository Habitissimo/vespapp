package com.habitissimo.vespapp;

import android.text.TextUtils;

public class Constants {
    public static final String API_BASE_URL = "";
    public static final String FOTOS_LIST = "com.habitissimo.vespapp.FOTOS_LIST";

    public static boolean isBaseApiUrlDefined() {
        return !TextUtils.isEmpty(API_BASE_URL);
    }
}
