package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
@SuppressWarnings("unchecked")

@WebServlet("/todolist")
public class ToDoListV2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<String> tasks = (ArrayList<String>)request.getSession().getAttribute("todolist");

        if(tasks == null) {
            tasks = new ArrayList<String>();
            request.getSession().setAttribute("todolist", tasks);
        }

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("<h1>To Do List :</h1>");
        response.getWriter().write("<ol>");

        for (String task : tasks) {
            response.getWriter().write("<li>" + task + "</li>");
        }

        response.getWriter().write("</ol>");
        response.getWriter().write("<form action='todolist' method='POST'>");
        response.getWriter().write("<label>Task:</label >");
        response.getWriter().write("<input type='text' name='task'/>");
        response.getWriter().write("<input type='submit' value='Add'/>");
        response.getWriter().write("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<String> tasks = (ArrayList<String>) request.getSession().getAttribute("todolist");

        String addedTask = request.getParameter("task");
        tasks.add(addedTask);

        request.getSession().setAttribute("todolist", tasks);

        doGet(request, response);
    }
}
