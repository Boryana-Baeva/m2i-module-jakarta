package com.demo.voitures.metier;

import java.util.ArrayList;

public class Garage {
    private ArrayList<Voiture> voitures = new ArrayList<>();

    public ArrayList<Voiture> getVoitures() {
        return voitures;
    }

    public void addVoiture(Voiture voiture) {
        voitures.add(voiture);
    }
}
