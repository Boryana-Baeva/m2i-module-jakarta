package com.demo.ecommerce.metier;

public class Produit {
    private int id;
    private String nom;
    private double prix;
    private String categorie;

    private static int count = 0;

    public Produit(String nom, String categorie, double prix) {
        this.id = ++count;
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", categorie='" + categorie + '\'' +
                '}';
    }
}
