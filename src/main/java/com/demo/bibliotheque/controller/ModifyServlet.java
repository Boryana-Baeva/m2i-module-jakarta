package com.demo.bibliotheque.controller;

import com.demo.bibliotheque.metier.GestionnaireLivres;
import com.demo.bibliotheque.metier.Livre;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/livres-modifier")
public class ModifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long isbn = Long.parseLong(request.getParameter("isbn"));
        GestionnaireLivres gestionnaireLivres = GestionnaireLivres.getGestionnaireLivres();

        Livre livre = gestionnaireLivres.getLivreByIsbn(isbn);
        request.setAttribute("titre", livre.getTitre());
        request.setAttribute("auteur", livre.getAuteur());
        request.setAttribute("isbn", livre.getIsbn());

        request.getRequestDispatcher("WEB-INF/bibliotheque/livreModify.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titre = request.getParameter("titre");
        String auteur = request.getParameter("auteur");
        long isbn = Long.parseLong(request.getParameter("isbn"));

        GestionnaireLivres gestionnaireLivres = GestionnaireLivres.getGestionnaireLivres();
        Livre livre = new Livre(titre, auteur, isbn);

        gestionnaireLivres.updateLivre(livre);

        response.sendRedirect("livres-search");
    }
}
