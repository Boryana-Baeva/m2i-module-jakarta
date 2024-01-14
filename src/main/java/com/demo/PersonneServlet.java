package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/personne")
public class PersonneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("<h1>Formulaire Personne</h1>");
        response.getWriter().write("<form action='personne' method='POST'>");
        response.getWriter().write("<label>Prénom:</label >");
        response.getWriter().write("<input type='text' name='prenom'/>");
        response.getWriter().write("<label>Nom:</label >");
        response.getWriter().write("<input type='text' name='nom'/>");
        response.getWriter().write("<input type='submit' value='Envoyer'/>");
        response.getWriter().write("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");

        System.out.println(prenom);
        System.out.println(nom);

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("<h1>Prénom: </h1>" + prenom);
        response.getWriter().write("<h1>Nom: </h1>" + nom);
    }
}
