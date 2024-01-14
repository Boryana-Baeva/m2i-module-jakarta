package com.demo.ecommerceV2.metier;

import java.util.ArrayList;

public class Stock {
    private ArrayList<Produit> produits = new ArrayList<>();
    private static Stock stock;

    private Stock(){
        produits.add(new Produit("Now And Then (The Beatles)", Categorie.getCategorieById(1), 25));
        produits.add(new Produit("One (The Beatles)", Categorie.getCategorieById(1), 29));
        produits.add(new Produit("The Chain (Fleetwood Mac)", Categorie.getCategorieById(1), 23));
        produits.add(new Produit("Before You Go (Lewis Capaldi)", Categorie.getCategorieById(2), 19));
        produits.add(new Produit("Ok Computer (Radiohead)", Categorie.getCategorieById(1), 15));
        produits.add(new Produit("Audioslave (Audioslave)", Categorie.getCategorieById(2), 13));
    }

    public static Stock getStock() {
        if(stock == null) {
            stock = new Stock();
        }
        return stock;
    }

    public ArrayList<Produit> getProduits() {
        return produits;
    }

    public boolean addProduit(Produit produit) {
        boolean success = false;
        var existing = produits.stream()
                .filter(p -> p.getId() == produit.getId() || p.getNom().equals(produit.getNom()))
                .findFirst()
                .orElse(null);

        if(existing == null) {
            produits.add(produit);
            success = true;
        }
        return success;
    }

    public Produit getProduitById(int id) {
        return produits.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public ArrayList<Produit> searchProduit(String search) {
        ArrayList<Produit> res = new ArrayList<Produit>();

        for(Produit p : produits) {
            if(p.getNom().toLowerCase().contains(search.toLowerCase())) {
                res.add(p);
            }
        }
        return res;
    }
}
