package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/evaluationAge")
public class PersonneAgeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.getRequestDispatcher("WEB-INF/personAge.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");

        request.setAttribute("prenom", prenom);
        request.setAttribute("nom", nom);

        int age = 0;
        boolean isAgeValide = true;
        try {
            age = Integer.parseInt(request.getParameter("age"));
            request.setAttribute("age", age);

        } catch (NumberFormatException e) {
            isAgeValide = false;
        }

        request.setAttribute("isAgeValide", isAgeValide);

        Boolean isMajor = age >= 18;
        request.setAttribute("isMajor", isMajor);

        doGet(request, response);

    }
}
