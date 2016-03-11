package com.habitissimo.vespapp;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.habitissimo.vespapp.api.VespappApi;
import com.habitissimo.vespapp.database.Database;

import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class Vespapp extends Application {
    private Database database;
    private VespappApi api;
    private Gson gson;

    public static Vespapp get(Context context) {
        return (Vespapp) context.getApplicationContext();
    }

    @Override public void onCreate() {
        super.onCreate();
        gson = new Gson();
        database = new Database(this, gson);

        if (Constants.isBaseApiUrlDefined()) {
            Retrofit retrofit = new Builder()
                    .baseUrl(Constants.API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            api = retrofit.create(VespappApi.class);
        }
    }

    public Database getDatabase() {
        return database;
    }

    public VespappApi getApi() {
        if (api == null)
            throw new RuntimeException("Constants.API_BASE_URL is not defined");

        return api;
    }
}
