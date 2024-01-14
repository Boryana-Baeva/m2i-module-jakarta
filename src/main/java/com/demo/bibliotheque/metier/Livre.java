package com.demo.bibliotheque.metier;

import java.math.BigInteger;

public class Livre {
    private String titre;
    private String auteur;
    private long isbn;

    public Livre(String titre, String auteur, long isbn) {
        this.titre = titre;
        this.auteur = auteur;
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", isbn=" + isbn +
                '}';
    }
}
