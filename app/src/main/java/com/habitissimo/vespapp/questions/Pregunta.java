package com.habitissimo.vespapp.questions;

import java.util.ArrayList;

/**
 * Created by archi on 10/03/16.
 */
public class Pregunta {

    private String mPregunta;
    private ArrayList<String> mRespuesta;

    public Pregunta(String apregunta) {
        mPregunta = apregunta;
        mRespuesta = new ArrayList<>();

    }

    public void addRespuesta(String respuesta) {
        mRespuesta.add(respuesta);
    }

    public String getPregunta() {
        return mPregunta;
    }

    public String getRespuesta(int j) {
        return mRespuesta.get(j);
    }


}