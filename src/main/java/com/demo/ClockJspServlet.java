package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@WebServlet("/clockMvc")
public class ClockJspServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime hour = LocalDateTime.now();

        request.setAttribute("hour", hour.format(formatter));

        Boolean ilFaitJour = false;
        request.setAttribute("ilFaitJour", ilFaitJour);

        ArrayList<String> jourSemaine = new ArrayList<>();
        jourSemaine.add("lundi");
        jourSemaine.add("mardi");
        jourSemaine.add("mercredi");
        jourSemaine.add("jeudi");
        jourSemaine.add("vendredi");
        jourSemaine.add("samedi");
        jourSemaine.add("dimanche");

        request.setAttribute("jours", jourSemaine);

        request.getRequestDispatcher("WEB-INF/clock.jsp")
                .forward(request, response);

    }
}
