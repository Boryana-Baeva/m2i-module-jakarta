package com.demo.voitures.metier;

public class Voiture {
    private String nom;
    private String marque;
    private String immatriculation;
    private int annee;

    public Voiture(String nom, String marque, String immatriculation, int annee) {
        this.nom = nom;
        this.marque = marque;
        this.immatriculation = immatriculation;
        this.annee = annee;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "nom='" + nom + '\'' +
                ", marque='" + marque + '\'' +
                ", immatriculation='" + immatriculation + '\'' +
                ", annee=" + annee +
                '}';
    }
}
