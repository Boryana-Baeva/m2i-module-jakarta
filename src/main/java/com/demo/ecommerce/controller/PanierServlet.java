package com.demo.ecommerce.controller;

import com.demo.ecommerce.metier.Panier;
import com.demo.ecommerce.metier.Produit;
import com.demo.ecommerce.metier.Stock;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
@WebServlet("/panier")
public class PanierServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve Panier from the Session
        Panier panier = (Panier)request.getSession().getAttribute("panier");

        if(panier != null) {
            request.setAttribute("total", panier.getTotal());
            request.setAttribute("totalItemsCount", panier.getTotalItemsCount());
        }

        request.getRequestDispatcher("WEB-INF/ecommerce/panier.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve Panier from the Session
        Panier panier = (Panier)request.getSession().getAttribute("panier");
        Stock stock = Stock.getStock();
        ArrayList<String> errors = new ArrayList<>();

        /* If button "Retirer" has been clicked
           Remove the whole item from the shopping cart
         */
        if(request.getParameter("id") != null) {
            String idProduitString = request.getParameter("id");
            int produitId = 0;
            try {
                produitId = Integer.parseInt(idProduitString);

                if (produitId <= 0)
                    errors.add("Erreur : L'id ne peut pas être négatif ou 0!");

                if (stock.getProduitById(produitId) == null)
                    errors.add("Erreur : Produit inexistant !");

            } catch (NumberFormatException e) {
                errors.add("Erreur : Le format de l'id du produit n'est pas valide !");
            }

            // If the provided parameter is valid and the product with such id is found -> remove Item
            if (errors.isEmpty()) {
                panier.removeFromPanier(produitId);
            }
        }

        /* If button "-" has been clicked
           Decrease the quanity of the item in the shopping cart
         */
        if(request.getParameter("idRemoveSingleItem") != null) {
            int idSingleItemRemoved = 0;
            try{
                idSingleItemRemoved = Integer.parseInt(request.getParameter("idRemoveSingleItem"));
            } catch (NumberFormatException e) {
                errors.add("Erreur : Le format de l'id du produit n'est pas valide !");
            }

            // If the provided parameter is valid and the product with such id is found -> decrease quantity of Item
            if(errors.isEmpty()) {
                panier.decreaseItemCount(idSingleItemRemoved);
            }
        }

        /* If button "+" has been clicked
           Increase the quanity of the item in the shopping cart
         */
        if(request.getParameter("idAddSingleItem") != null) {
            int idSingleItemAdded = 0;
            try{
                idSingleItemAdded = Integer.parseInt(request.getParameter("idAddSingleItem"));
            } catch (NumberFormatException e) {
                errors.add("Erreur : Le format de l'id du produit n'est pas valide !");
            }

            // If the provided parameter is valid and the product with such id is found -> increase quantity of Item
            if(errors.isEmpty()) {
                panier.increaseItemCount(idSingleItemAdded);
            }
        }

        // Set attribute errors in order to display them if any
        request.setAttribute("errors", errors);

        doGet(request, response);
    }
}
