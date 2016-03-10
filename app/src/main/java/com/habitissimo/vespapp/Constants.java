package com.habitissimo.vespapp;

import android.text.TextUtils;

public class Constants {
    public static final String API_BASE_URL = "";

    public static boolean isBaseApiUrlDefined() {
        return !TextUtils.isEmpty(API_BASE_URL);
    }
}
