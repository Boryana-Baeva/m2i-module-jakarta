package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Random;

@WebServlet("/guess")
public class NombreDevinerServlet extends HttpServlet {
    int randomNumber = new Random().nextInt(1,10);
    int tentativesCount = 0;
    int MAX_TENTATIVES = 3;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int number = Integer.parseInt(request.getParameter("n"));
            tentativesCount++;

            if(tentativesCount < 3 && number == randomNumber) {
                response.getWriter().write("<h1>Gagné ! Le nombre était bien " + randomNumber + ".</h1>");
                tentativesCount = 0;
                randomNumber = new Random().nextInt(1,10);
            } else if (tentativesCount >= 3) {
                response.getWriter().write("<h1>Perdu ! ");
                tentativesCount = 0;
            }
            else {
                if (number > randomNumber) {
                    response.getWriter().write("<h1>Trop grand ! ");
                } else {
                    response.getWriter().write("<h1>Trop petit ! ");
                }

                response.getWriter().write("Il vous restent : " + (MAX_TENTATIVES - tentativesCount) + " tentatives.</h1>");
            }
        }
        catch (NumberFormatException e) {
            response.getWriter().write("<h1>Erreur : Essayez avec un nombre valide !<h1>");
        }

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
    }
}
