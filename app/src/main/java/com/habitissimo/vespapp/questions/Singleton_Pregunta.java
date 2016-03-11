package com.habitissimo.vespapp.questions;

import android.content.Context;

import com.habitissimo.vespapp.R;

import java.util.ArrayList;

/**
 * Created by archi on 10/03/16.
 */
public class Singleton_Pregunta {

    private static Singleton_Pregunta sp;
    private ArrayList<Pregunta> mPreguntas;
    private Context mContext;

    public Singleton_Pregunta(Context context) {

        boolean salir = false;
        mContext = context;
        mPreguntas = new ArrayList<>();
        String[] preguntes = mContext.getResources().getStringArray(R.array.preguntas);
        int[] id_respuesta = mContext.getResources().getIntArray(R.array.id_respuesta);
        String[] respostes = mContext.getResources().getStringArray(R.array.respuesta);
        for (int i = 0; i < preguntes.length; i++) {
            mPreguntas.add(new Pregunta(preguntes[i]));
            salir = false;
            for (int j = i; !salir; j++) {

                if (i == id_respuesta[j]) {
                    mPreguntas.get(i).addRespuesta(respostes[j]);
                } else {
                    salir = true;
                }


            }

        }

    }

    public static Singleton_Pregunta getInstace(Context context) {

        if (sp == null) {
            sp = new Singleton_Pregunta(context.getApplicationContext());
        }
        return sp;
    }

    public String getPregunta(int i) {
        return mPreguntas.get(i).getPregunta();
    }

    public String getRespuesta(int i, int j) {
        return mPreguntas.get(i).getRespuesta(j);
    }

}
