package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Random;

@WebServlet("/jeu")
public class NombreDeviner1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int number = Integer.parseInt(request.getParameter("n"));
            int randomNumber = new Random().nextInt(1,10);

            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");

            if(number == randomNumber) {
                response.getWriter().write("<h1>Gagné ! Le nombre était bien " + randomNumber + ".</h1>");
            } else {
                response.getWriter().write("<h1>Perdu ! Le nombre était ");

                if (number > randomNumber) {
                    response.getWriter().write("inferieur à " + number + " (" + randomNumber +").</h1>");
                } else {
                    response.getWriter().write("supperieur à " + number + " (" + randomNumber +").</h1>");
                }
            }
        }
        catch (NumberFormatException e) {
            response.getWriter().write("<h1>Erreur : Essayez avec un nombre valide !<h1>");
        }

    }
}
