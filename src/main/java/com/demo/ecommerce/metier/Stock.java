package com.demo.ecommerce.metier;

import com.demo.bibliotheque.metier.Livre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Stock {
    private ArrayList<Produit> produits = new ArrayList<>();
    private static Stock stock;

    private Stock(){
        produits.add(new Produit("Now And Then (The Beatles)", "vinyl", 25));
        produits.add(new Produit("One (The Beatles)", "vinyl", 29));
        produits.add(new Produit("The Chain (Fleetwood Mac)", "vinyl", 23));
        produits.add(new Produit("Before You Go (Lewis Capaldi)", "cd", 19));
        produits.add(new Produit("Ok Computer (Radiohead)", "cd", 15));
        produits.add(new Produit("Audioslave (Audioslave)", "cd", 13));
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
