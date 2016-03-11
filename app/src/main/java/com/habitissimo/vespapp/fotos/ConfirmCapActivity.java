package com.habitissimo.vespapp.fotos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.habitissimo.vespapp.Constants;
import com.habitissimo.vespapp.R;
import com.habitissimo.vespapp.database.Database;

public class ConfirmCapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_cap);

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

    private void initAlbum() {
        // obtener lista del database
        ListaFotos listaFotos = Database.get(this).load(Constants.FOTOS_LIST, ListaFotos.class);

        // inicializar recicleview
        GridLayoutManager gridLayout = new GridLayoutManager(this, 2);

        RecyclerView rView = (RecyclerView) findViewById(R.id.recycle_fotos);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(gridLayout);

        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(this, listaFotos.getLista());
        rView.setAdapter(rcAdapter);
    }


}
