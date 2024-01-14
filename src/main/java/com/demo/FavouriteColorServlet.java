package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/favourite")
public class FavouriteColorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String color = request.getParameter("color");

        if(color != null) {
            request.getSession().setAttribute("favourite-color", color);
        }

        if(request.getSession().getAttribute("favourite-color") == null) {
            response.getWriter().write("<p>Vous n'avez pas encore enregistré de couleur.</p>");
        } else {
            response.getWriter().write("<h1>Votre couleur préferée : </h1>");
            response.getWriter().write((String)request.getSession().getAttribute("favourite-color"));
        }

    }
}
