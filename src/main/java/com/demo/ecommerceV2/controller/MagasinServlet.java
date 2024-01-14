package com.demo.ecommerceV2.controller;

import com.demo.ecommerceV2.metier.Panier;
import com.demo.ecommerceV2.metier.Produit;
import com.demo.ecommerceV2.metier.Stock;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/store")
public class MagasinServlet extends HttpServlet {
    static final int MAX_ITEMS_PER_PAGE =  5;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Stock stock = Stock.getStock();
        ArrayList<Produit> produits = stock.getProduits();
        request.setAttribute("produits", produits);

        List<Produit> produitsPaginated = new ArrayList<>();
        ArrayList<String> errors = new ArrayList<>();

        // Check if the stock contains enough products to show pagination
        if(produits.size() > MAX_ITEMS_PER_PAGE) {
            int pageNb = 1;
            if(request.getParameter("page") != null) {
                try {
                    pageNb = Integer.parseInt(request.getParameter("page"));
                } catch (NumberFormatException e) {
                    errors.add("Erreur : Le nombre de page doit être un nombre !");
                }
            }
            // Calculate how many pages the products must be split into
            int pageCount = (int)Math.ceil((double) produits.size() / MAX_ITEMS_PER_PAGE);

            // Prevent invalid input for the pageNb parameter
            if(pageNb > pageCount || pageNb < 1) {
                errors.add("Erreur : Page inexistante !");
            }

            // If the provided pageNb parameter is valid -> extract the products to display on the requested page
            if(errors.isEmpty()) {
                int startIndex = ((pageNb-1) * MAX_ITEMS_PER_PAGE);
                int endIndex;
                if(pageNb < pageCount) {
                    endIndex = startIndex + MAX_ITEMS_PER_PAGE;
                } else {
                    endIndex = produits.size();
                }

                produitsPaginated = produits.subList(startIndex, endIndex);

                request.setAttribute("produits", produitsPaginated);
                request.setAttribute("page", pageNb);
                request.setAttribute("pageCount", pageCount);
            }

        }

        // Set attribute errors in order to display them if any
        request.setAttribute("errors", errors);

        request.getRequestDispatcher("WEB-INF/ecommerceV2/magasin.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Stock stock = Stock.getStock();
        // Retrieve Panier from the Session
        Panier panier = (Panier)request.getSession().getAttribute("panier");

        // If Panier still empty -> get instance
        if(panier == null) {
            panier = Panier.getPanier();        }

        ArrayList<String> errors = new ArrayList<>();
        int id = Integer.parseInt(request.getParameter("id"));

        // Check if the product with such id exists before adding it to the shopping cart
        Produit produit = stock.getProduitById(id);
        if(produit == null) {
            errors.add("Erreur : Ce produit n'est pas dans la liste !");
            request.setAttribute("errors", errors);
        } else {
            panier.addToPanier(produit);
            request.getSession().setAttribute("panier", panier);
            request.getSession().setAttribute("items", panier.getItems());
        }

        doGet(request, response);
    }
}
