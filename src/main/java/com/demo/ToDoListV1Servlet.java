package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/tasklist")
public class ToDoListV1Servlet extends HttpServlet {
    ArrayList<String> tasks = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("<h1>To Do List :</h1>");
        response.getWriter().write("<ol>");
        for (String task : tasks) {
            response.getWriter().write("<li>" + task + "</li>");
        }
        response.getWriter().write("</ol>");
        response.getWriter().write("<form action='tasklist' method='POST'>");
        response.getWriter().write("<label>Task:</label >");
        response.getWriter().write("<input type='text' name='task'/>");
        response.getWriter().write("<input type='submit' value='Add'/>");
        response.getWriter().write("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String addedTask = request.getParameter("task");
        tasks.add(addedTask);

        doGet(request, response);
    }
}
