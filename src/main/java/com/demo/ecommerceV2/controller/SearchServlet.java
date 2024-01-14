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

@WebServlet("/product-search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Stock stock = Stock.getStock();
        request.setAttribute("produits", stock.getProduits());

        request.getRequestDispatcher("WEB-INF/ecommerceV2/search.jsp")
                .forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Stock stock = Stock.getStock();
        String searchQuery = request.getParameter("search");

        ArrayList<Produit> searchResult = stock.searchProduit(searchQuery);

        if(!searchResult.isEmpty() && !searchQuery.isBlank()) {
            request.setAttribute("searchResult", searchResult);
        } else  {
            request.setAttribute("errorMsg", "Aucun resultat trouvé pour «" + searchQuery + "».");
        }


        doGet(request, response);
    }
}
