package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/salutation")
public class PrenomServlet extends HttpServlet {
    /*String prenom;
    String nom;*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String prenomQuery = request.getParameter("prenom");
        if(prenomQuery != null) {
            request.getSession().setAttribute("prenom", prenomQuery);
            //prenom = prenomQuery;
        }

        String nomQuery = request.getParameter("nom");
        if(nomQuery != null) {
            request.getSession().setAttribute("nom", nomQuery);
            //nom = nomQuery;
        }

        String prenomSession = (String)request.getSession().getAttribute("prenom");
        String nomSession = (String)request.getSession().getAttribute("nom");

        response.getWriter().write("<h1>Bonjour, tu t'appelles : </h1>");
        if(prenomSession != null) {
            response.getWriter().write("<h1>Prénom : </h1>" + prenomSession);
        }
        if(nomSession != null) {
            response.getWriter().write("<h1>Nom : </h1>" + nomSession);
        }

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

    }
}
