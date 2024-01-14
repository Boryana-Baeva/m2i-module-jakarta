package com.demo.ecommerce.controller;

import com.demo.ecommerce.metier.Produit;
import com.demo.ecommerce.metier.Stock;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Stock stock = Stock.getStock();
        request.setAttribute("produits", stock.getProduits());

        request.getRequestDispatcher("WEB-INF/ecommerce/admin.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Stock stock = Stock.getStock();
        String nom = request.getParameter("nom");
        String categorie = request.getParameter("categorie");
        String prixString = request.getParameter("prix");

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
