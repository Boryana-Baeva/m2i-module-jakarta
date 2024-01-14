package com.demo.bibliotheque.controller;

import com.demo.bibliotheque.metier.GestionnaireLivres;
import com.demo.bibliotheque.metier.Livre;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/livres-ajouter")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/bibliotheque/livreAdd.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestionnaireLivres gestionnaireLivres = GestionnaireLivres.getGestionnaireLivres();
        ArrayList<Livre> livres = gestionnaireLivres.getLivres();

        String titre = request.getParameter("titre");
        String auteur = request.getParameter("auteur");
        String isbnString = request.getParameter("isbn");

        String errorMsg = "";

        long isbn = 0L;
        try {
            isbn = Long.parseLong(isbnString);
        } catch (NumberFormatException e) {
            errorMsg += "L'ISBN doit être un nombre ! <br>";
        }

        if(titre.isBlank()) {
            errorMsg += "Le titre ne peut pas être vide ! <br>";
        }

        if(auteur.isBlank()) {
            errorMsg += "L'auteur ne peut pas être vide ! <br>";
        }

        if(isbn < 9780000000000L) {
            errorMsg += "L'ISBN doit commencer par 978 et il doit être composé de 13 chiffres ! <br>";
        }
        else {
            if(!gestionnaireLivres.addLivre(new Livre(titre, auteur, isbn))) {
                errorMsg += "Le livre avec le ISBN «" + isbn + "» existe déjà dans la liste! <br>";
            }
        }

        request.setAttribute("errorMsg", errorMsg);

        if(errorMsg.isEmpty()) {
            response.sendRedirect("livres-show");
        } else {
            request.setAttribute("titre", titre);
            request.setAttribute("auteur", auteur);
            request.setAttribute("isbn", isbnString);
            doGet(request, response);
        }

    }
}
