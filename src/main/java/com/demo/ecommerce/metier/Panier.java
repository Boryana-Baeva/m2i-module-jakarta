package com.demo.ecommerce.metier;

import java.util.HashMap;
import java.util.Map.Entry;

public class Panier {
    private double total;
    private int totalItemsCount = 0;
    private HashMap<Produit, Integer> items = new HashMap<>();

    public Panier() {
        calculateTotal();
    }

    public HashMap<Produit, Integer> getItems() {
        return items;
    }

    public double getTotal() {
        calculateTotal();
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setItems(HashMap<Produit, Integer> items) {
        this.items = items;
    }

    private void calculateTotal() {
        double total = 0;

        for(Entry<Produit, Integer> item : items.entrySet()) {
            total += item.getKey().getPrix() * item.getValue();
        }

        this.total = total;
    }

    public void addToPanier(Produit produit) {
        totalItemsCount++;
        if(!items.containsKey(produit)) {
            items.put(produit, 1);
        } else {
            // Get existing product item in order to increase its quantity in the shopping cart
            Entry<Produit, Integer> existingEntry = items.entrySet().stream()
                    .filter(p -> p.getKey().getId() == produit.getId())
                    .findFirst()
                    .orElse(null);

            int quantity = 0;
            if(existingEntry != null) {
                quantity = existingEntry.getValue();
                quantity++;

                existingEntry.setValue(quantity);
            }
        }
    }

    public void removeFromPanier(int id) {
        // Check if such item exists and if yes -> retrieve it
        Entry<Produit, Integer> existingEntry = items.entrySet().stream()
                .filter(p -> p.getKey().getId() == id)
                .findFirst()
                .orElse(null);

        if(existingEntry != null) {
            items.remove(existingEntry.getKey());

            // Modify the total count of items accordingly after removal if item
            int quantity = existingEntry.getValue();
            totalItemsCount -= quantity;
        }
    }

    public void decreaseItemCount(int id) {
        // Check if such item exists and if yes -> retrieve it
        Entry<Produit, Integer> existingEntry = items.entrySet().stream()
                .filter(p -> p.getKey().getId() == id)
                .findFirst()
                .orElse(null);

        // Modify the total count of items and the item quantity accordingly after removal if item
        if(existingEntry != null) {
            int quantity = existingEntry.getValue();
            existingEntry.setValue(--quantity);
            totalItemsCount--;
        }
    }

    public void increaseItemCount(int id) {
        // Check if such item exists and if yes -> retrieve it
        Entry<Produit, Integer> existingEntry = items.entrySet().stream()
                .filter(p -> p.getKey().getId() == id)
                .findFirst()
                .orElse(null);

        // Modify the total count of items and the item quantity accordingly after removal if item
        if(existingEntry != null) {
            int quantity = existingEntry.getValue();
            existingEntry.setValue(++quantity);
            totalItemsCount++;
        }
    }

    public int getTotalItemsCount() {
        return totalItemsCount;
    }

    public void setTotalItemsCount(int totalItemsCount) {
        this.totalItemsCount = totalItemsCount;
    }
}
