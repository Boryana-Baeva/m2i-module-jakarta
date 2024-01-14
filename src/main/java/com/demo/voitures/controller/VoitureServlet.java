package com.demo.voitures.controller;

import com.demo.voitures.metier.Garage;
import com.demo.voitures.metier.Voiture;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/voitures")
public class VoitureServlet extends HttpServlet {
    private Garage garage = new Garage();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Voiture> voitures = garage.getVoitures();
        request.setAttribute("voitures", voitures);

        request.getRequestDispatcher("WEB-INF/voitures.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String marque = request.getParameter("marque");
        String immatriculation = request.getParameter("immatriculation");
        String anneeString = request.getParameter("annee");

        int annee = 0;
        try {
            annee = Integer.parseInt(anneeString);
        }
        catch (NumberFormatException e) {
            request.setAttribute("errorMsg", e.getMessage());
        }

        if(annee < 1900) {
            String errorMsg = "Erreur : Le format de l'année n'est pas valide !";
            request.setAttribute("errorMsg", errorMsg);
        } else {
            Voiture voiture = new Voiture(nom, marque, immatriculation, annee);
            garage.addVoiture(voiture);
        }

        doGet(request, response);
    }
}
