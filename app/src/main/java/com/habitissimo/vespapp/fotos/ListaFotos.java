package com.habitissimo.vespapp.fotos;

import java.util.List;

/**
 * Created by mariano on 11/03/16.
 */
public class ListaFotos {

    private List<String> lista;

    public ListaFotos(List<String> lista) {
        this.lista = lista;
    }

    public List<String> getLista() {
        return lista;
    }
}
