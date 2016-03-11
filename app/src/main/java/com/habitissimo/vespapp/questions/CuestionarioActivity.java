package com.habitissimo.vespapp.questions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.habitissimo.vespapp.R;

public class CuestionarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cuestionario_activity);
        // Set a toolbar to replace the action bar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setTitleTextColor(getResources().getColor(R.color.colorTitulo));

        Singleton_Pregunta sp = Singleton_Pregunta.getInstace(this);
        Toast.makeText(this, sp.getRespuesta(1, 0), Toast.LENGTH_LONG).show();


    }
}
