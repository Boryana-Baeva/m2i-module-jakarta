package com.demo.multiServlet.controller;

import com.demo.multiServlet.metier.AppData;
import com.demo.multiServlet.metier.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/vip")
public class ShowPersonsVIPServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Person> listPersons = AppData.annuaire.getVIPs();
        request.setAttribute("listPersons", listPersons);
        request.setAttribute("isVIP", true);

        request.getRequestDispatcher("WEB-INF/showPersons.jsp")
                .forward(request, response);
    }
}
