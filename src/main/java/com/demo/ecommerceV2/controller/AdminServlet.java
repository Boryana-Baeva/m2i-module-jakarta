package com.demo.ecommerceV2.controller;

import com.demo.ecommerceV2.metier.Categorie;
import com.demo.ecommerceV2.metier.Produit;
import com.demo.ecommerceV2.metier.Stock;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/administration")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Stock stock = Stock.getStock();
        request.setAttribute("produits", stock.getProduits());
        request.setAttribute("categories", Categorie.getCategories());

        request.getRequestDispatcher("WEB-INF/ecommerceV2/admin.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Stock stock = Stock.getStock();
        String nom = request.getParameter("nom");
        String prixString = request.getParameter("prix");

        int categorieId = Integer.parseInt(request.getParameter("categories"));
        Categorie categorie = Categorie.getCategorieById(categorieId);

        ArrayList<String> errors = new ArrayList<>();

        double prix = 0.0;
        try {
            prix = Double.parseDouble(prixString);
        } catch (NumberFormatException e) {
            errors.add("Erreur : Le prix doit être un nombre !");
        }

        if(errors.isEmpty()){
            if(!stock.addProduit(new Produit(nom, categorie, prix))) {
                errors.add("Erreur : Un produit avec le même nom existe déjà !");
                request.setAttribute("nom", nom);
                request.setAttribute("categorie", categorie);
                request.setAttribute("prix", prix);
            }
        }

        request.setAttribute("errors", errors);

        doGet(request, response);
    }
}
