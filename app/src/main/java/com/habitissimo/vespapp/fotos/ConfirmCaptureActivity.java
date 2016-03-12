package com.habitissimo.vespapp.fotos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.habitissimo.vespapp.Constants;
import com.habitissimo.vespapp.R;
import com.habitissimo.vespapp.Vespapp;
import com.habitissimo.vespapp.database.Database;
import com.habitissimo.vespapp.dialog.LoadingDialog;
import com.habitissimo.vespapp.dialog.LoadingDialog.Listener;
import com.habitissimo.vespapp.questions.Sighting;

import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfirmCaptureActivity extends AppCompatActivity {

    public static final String TAG = "ConfirmCaptureActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_cap);
        ButterKnife.bind(this);

        initToolbar();
        initAlbum();
        initAddBtn();
    }

    private void initToolbar() {
        ImageView backBtn = (ImageView) findViewById(R.id.btn_toolbar_back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initAddBtn() {
        Button btn = (Button) findViewById(R.id.btn_añadir_foto);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @OnClick(R.id.btn_nido) void onNidoPressed() {
        onTypeOfSightPressed(Sighting.TYPE_NEST);
    }

    @OnClick(R.id.btn_avispa) void onAvispaPressed() {
        onTypeOfSightPressed(Sighting.TYPE_WASP);
    }

    private void onTypeOfSightPressed(int type) {
//        showLoading();
        Sighting sighting = new Sighting();
        sighting.type = type;
        sighting.lat = 1;
        sighting.lng = 2;
        sighting.free_text = "Vacío";//Es requerido
        Call<Sighting> call = Vespapp.get(this).getApi().createSighting(sighting);
        call.enqueue(new Callback<Sighting>() {
            @Override public void onResponse(Call<Sighting> call, Response<Sighting> response) {
                onSightingCreated();
            }

            @Override public void onFailure(Call<Sighting> call, Throwable t) {
                onSightingCreationError(t);
            }
        });
    }

    private void showLoading() {
        LoadingDialog.show(this, new Listener() {
            @Override public void onDialogDismissed() {
                //Put something
            }
        });
    }

    private void onSightingCreated() {
        //TODO:
//        ListaFotos listaFotos = getListaFotos();
//        for (String photoPath : listaFotos.getLista())
//        {
//        Vespapp.get(this).getApi().addPhoto(VespappApiHelper.buildPhotoApiParameter(new File(photoPath)));
//        }
    }

    private void onSightingCreationError(Throwable t) {
        Log.e(TAG, "Error creating sighting: " + t);
    }

    private void initAlbum() {
        // obtener lista del database
        ListaFotos listaFotos = getListaFotos();

        // inicializar recicleview
        GridLayoutManager gridLayout = new GridLayoutManager(this, 2);

        RecyclerView rView = (RecyclerView) findViewById(R.id.recycle_fotos);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(gridLayout);

        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(this, listaFotos.getLista());
        rView.setAdapter(rcAdapter);
    }

    private ListaFotos getListaFotos() {
        return Database.get(this).load(Constants.FOTOS_LIST, ListaFotos.class);
    }
}
