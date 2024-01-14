package com.demo.singleton;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/singleton2")
public class Singleton2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Annuaire annuaire = Annuaire.getAnnuaire();
        resp.getWriter().write("<h1>Le nombre des personnes dans l'annuaire (Singleton2): " + annuaire.getPersonnes().size());
    }
}
