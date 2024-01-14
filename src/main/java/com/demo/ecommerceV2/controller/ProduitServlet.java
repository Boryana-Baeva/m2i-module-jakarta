package com.demo.ecommerceV2.controller;

import com.demo.ecommerceV2.metier.Produit;
import com.demo.ecommerceV2.metier.Stock;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/product")
public class ProduitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Stock stock = Stock.getStock();
        String idProduitString = request.getParameter("id");
        ArrayList<String> errors = new ArrayList<>();

        int produitId = 0;
        try{
            produitId = Integer.parseInt(idProduitString);

            if(produitId <= 0)
                errors.add("Erreur : L'id ne peut pas être négatif ou 0!");

            if(stock.getProduitById(produitId) == null)
                errors.add("Erreur : Produit inexistant !");

        } catch (NumberFormatException e) {
            errors.add("Erreur : Le format de l'id du produit n'est pas valide !");
        }

        if(errors.isEmpty()) {
            Produit produit = stock.getProduitById(produitId);
            request.setAttribute("produit", produit);
        }

        request.setAttribute("errors", errors);

        request.getRequestDispatcher("WEB-INF/ecommerceV2/produit.jsp")
                .forward(request, response);
    }
}
