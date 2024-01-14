package com.demo.ecommerceV2.metier;

import java.util.ArrayList;

public class Panier {
    private double total;
    private int totalItemsCount;
    ArrayList<PanierItem> items = new ArrayList<>();

    private static Panier panier;

    public static Panier getPanier() {
        if(panier == null) {
            panier = new Panier();
        }
        return panier;
    }

    private Panier() {
    }

    public ArrayList<PanierItem> getItems() {
        return items;
    }

    public double getTotal() {
        calculateTotal();
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setItems(ArrayList<PanierItem> items) {
        this.items = items;
    }

    private void calculateTotal() {
        double total = 0;

        for(PanierItem item : items) {
            total += item.getProduit().getPrix() * item.getQuantite();
        }

        this.total = total;
    }

    private void calculateTotalItemsCount() {
        int totalItemsCount = 0;

        for(PanierItem item : items) {
            totalItemsCount += item.getQuantite();
        }

        this.totalItemsCount = totalItemsCount;
    }

    public void addToPanier(Produit produit) {
        // Get existing product item or null
        PanierItem item = items.stream()
                                .filter(i -> i.getProduit().getId() == produit.getId())
                                .findFirst()
                                .orElse(null);

        if(item == null) {
            items.add(new PanierItem(produit, 1));
        }
        else {
            item.setQuantite(item.getQuantite()+1);
        }
    }

    public void removeFromPanier(int id) {
        // Check if such item exists before action
        items.stream()
                .filter(i -> i.getProduit().getId() == id)
                .findFirst()
                .ifPresent(item -> items.remove(item));
    }

    public void decreaseItemCount(int id) {
        // Check if such item exists before action
        items.stream()
                .filter(i -> i.getProduit().getId() == id)
                .findFirst()
                .ifPresent(item -> item.setQuantite(item.getQuantite()-1));
    }

    public void increaseItemCount(int id) {
        // Check if such item exists before action
        items.stream()
                .filter(i -> i.getProduit().getId() == id)
                .findFirst()
                .ifPresent(item -> item.setQuantite(item.getQuantite()+1));
    }

    public int getTotalItemsCount() {
        calculateTotalItemsCount();
        return totalItemsCount;
    }

    public void setTotalItemsCount(int totalItemsCount) {
        this.totalItemsCount = totalItemsCount;
    }
}
