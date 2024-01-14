package com.demo.plantes.metier;

import java.util.ArrayList;

public class Serre {
    private ArrayList<Plante> plantes = new ArrayList<>();

    public void addPlante(Plante plante) {
        plantes.add(plante);
    }

    public ArrayList<Plante> getPlantes() {
        return plantes;
    }
}
