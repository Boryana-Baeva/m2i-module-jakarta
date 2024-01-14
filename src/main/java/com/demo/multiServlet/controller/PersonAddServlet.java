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

@WebServlet("/addPerson")
public class PersonAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Annuaire annuaire = AppData.annuaire;
        request.setAttribute("allPersons", annuaire.getAllPersons());

        request.getRequestDispatcher("WEB-INF/addPerson.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        boolean isVip= request.getParameter("isVIP") != null;

        Person person = new Person(firstName, lastName, phoneNumber, address, isVip);
        AppData.annuaire.addPerson(person);


        doGet(request, response);

    }
}
