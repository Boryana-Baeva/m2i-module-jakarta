package com.demo.plantes.metier;

public class Plante {
    private String nom;
    private String espece;
    private String couleur;
    private int age;

    public Plante(String nom, String espece, String couleur, int age) {
        this.nom = nom;
        this.espece = espece;
        this.couleur = couleur;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Plante{" +
                "nom='" + nom + '\'' +
                ", espece='" + espece + '\'' +
                ", couleur='" + couleur + '\'' +
                ", age=" + age +
                '}';
    }
}
