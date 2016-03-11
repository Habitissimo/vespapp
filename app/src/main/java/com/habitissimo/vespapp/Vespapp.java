package com.habitissimo.vespapp;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.google.gson.Gson;
import com.habitissimo.vespapp.api.VespappApi;
import com.habitissimo.vespapp.database.Database;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Picasso.Listener;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class Vespapp extends Application {
    private static final boolean FORCE_MOCK = true;

    private Database database;
    private VespappApi api;
    private Gson gson;
    private OkHttpClient httpClient;

    public static Vespapp get(Context context) {
        return (Vespapp) context.getApplicationContext();
    }

    @Override public void onCreate() {
        super.onCreate();
        gson = new Gson();
        database = new Database(this, gson);

        httpClient = new OkHttpClient.Builder()
                .build();
        Picasso.setSingletonInstance(new Picasso.Builder(this)
                .listener(new Listener() {
                    @Override public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                        Log.d("Picasso", "Image failed loading: " + exception);
                    }
                })
                .build());

        if (Constants.isBaseApiUrlDefined() && !FORCE_MOCK) {

            Retrofit retrofit = new Builder()
                    .baseUrl(Constants.API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(httpClient)
                    .build();
            api = retrofit.create(VespappApi.class);
        } else {
            api = new MockedVespappApi();
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
