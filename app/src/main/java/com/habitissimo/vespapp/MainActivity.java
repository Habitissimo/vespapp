package com.habitissimo.vespapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {
    @Bind(R.id.title_text) TextView titleTextView;
    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //En vez de usar findViewById(), se puede llamar a ButterKnife y usar @Bind y @OnClick
        //Hay que llamarlo después del setContentView!
        ButterKnife.bind(this);

        controller = new MainController();
        controller.takeView(this);
        controller.onLoad("Inicio");
    }

    //Puedes usar cualquier nombre de método
    @OnClick(R.id.clickme_button) void onClickMePressed() {
        controller.onClickMePressed();
    }

    @Override public String title() {
        return titleTextView.getText().toString();
    }

    @Override public void title(String title) {
        titleTextView.setText(title);
    }
}
