package com.demo.singleton;

import com.demo.singleton.Personne;

import java.util.ArrayList;

public  class Annuaire {
    private static Annuaire singleton;
    private ArrayList<Personne> personnes = new ArrayList<>();

    private Annuaire() {
        personnes.add(new Personne("John", "Doe"));
        personnes.add(new Personne("Jane", "Smith"));
    }

    public static Annuaire getAnnuaire() {
        if(singleton == null) {
            singleton = new Annuaire();
        }
        return singleton;
    }

    public ArrayList<Personne> getPersonnes() {
        return personnes;
    }
}
