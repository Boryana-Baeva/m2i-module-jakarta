package com.demo.multiServlet.controller;

import com.demo.multiServlet.metier.Annuaire;
import com.demo.multiServlet.metier.AppData;
import com.demo.multiServlet.metier.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/showPersons")
public class ShowPersonsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Person> listPersons = AppData.annuaire.getNonVIPs();
        request.setAttribute("listPersons", listPersons);
        request.setAttribute("isVIP", false);

        request.getRequestDispatcher("WEB-INF/showPersons.jsp")
                .forward(request, response);
    }

    /*@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isVIP = Boolean.parseBoolean(request.getParameter("vip"));
        ArrayList<Person> listPersons = new ArrayList<>();
        listPersons = isVIP ? AppData.annuaire.getVIPs() : AppData.annuaire.getNonVIPs();

        request.setAttribute("listPersons", listPersons);
        request.setAttribute("isVIP", isVIP);

        request.getRequestDispatcher("WEB-INF/showPersons.jsp")
                .forward(request, response);

    }*/
}
