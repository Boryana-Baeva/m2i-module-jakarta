package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Random;

@WebServlet("/jeu-nombre")
public class NombreDeviner3Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        String nombreString = request.getParameter("nombre");

        // initialisation nouvelle partie
        if (session.getAttribute("tentativesRestantes") == null ||
                (int)session.getAttribute("tentativesRestantes") == 0) {
            initialisationPartie(session);
        }

        try { // permet de gérer le cas où nombre n'est pas un nombre ou il est null
            int proposition = Integer.parseInt(nombreString);
            int randomNumber = (int) session.getAttribute("randomNumber");
            int tentativesRestantes = (int)session.getAttribute("tentativesRestantes");

            // Algo du jeu:
            if (randomNumber == proposition) {
                response.getWriter().write("<h1>Bravo, vous avez gagné !</h1>");
                initialisationPartie(session);
            } else {
                tentativesRestantes--;
                session.setAttribute("tentativesRestantes", tentativesRestantes);

                if (proposition < (int)session.getAttribute("randomNumber")) {
                    response.getWriter().write("<h1>trop petit !</h1>");
                } else {
                    response.getWriter().write("<h1>trop grand !</h1>");
                }

                // Triche
                response.getWriter().write("<p>Nombre à deviner: </p>" + session.getAttribute("randomNumber"));
                response.getWriter().write("<p>Tentatives restantes: </p>" + session.getAttribute("tentativesRestantes"));
            }

            if ((int)session.getAttribute("tentativesRestantes") == 0) {
                response.getWriter().write("<h1>Perdu, nombre de tentatives restantes egal à zero !</h1>");
            }
        } catch (NumberFormatException numberFormatException) {
            response.getWriter().write("<h1>Erreur : ce n'est pas un nombre</h1>");
        }
    }
        private void initialisationPartie(HttpSession session){
            session.setAttribute("tentativesRestantes", 3);
            session.setAttribute("randomNumber", (int)new Random().nextInt(1,10));
        }
}
