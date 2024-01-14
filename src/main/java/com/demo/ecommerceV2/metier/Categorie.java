package com.demo.ecommerceV2.metier;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Categorie {
    private int id;
    private String nom;

    private static int count = 0;

    private static ArrayList<Categorie> categories = new ArrayList<>(
            Arrays.asList(
                    new Categorie("Vinyl"),
                    new Categorie("Cassette"),
                    new Categorie("CD"),
                    new Categorie("DVD")
            )
    );

    public Categorie(String nom) {
        this.id = ++count;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public static ArrayList<Categorie> getCategories() {
        return categories;
    }

    public static void setCategories(ArrayList<Categorie> categories) {
        Categorie.categories = categories;
    }

    public static Categorie getCategorieById(int id) {
        return categories.stream()
                        .filter(c -> c.getId() == id)
                        .findFirst()
                        .orElse(null);
    }

    @Override
    public String toString() {
        return nom;
    }
}
