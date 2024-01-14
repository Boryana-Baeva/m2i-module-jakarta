package com.demo.bibliotheque.controller;

import com.demo.bibliotheque.metier.GestionnaireLivres;
import com.demo.bibliotheque.metier.Livre;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/livres-show")
public class ShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestionnaireLivres gestionnaireLivres = GestionnaireLivres.getGestionnaireLivres();
        ArrayList<Livre> livres = gestionnaireLivres.getLivres();
        request.setAttribute("livres", livres);

        List<Livre> livresPaginated = new ArrayList<>();

        int n = 0;
        int pageNb = 0;
        String errorMsg = "";
        try {
            n = Integer.parseInt(request.getParameter("n"));
            pageNb = Integer.parseInt(request.getParameter("pageNb"));
        } catch (NumberFormatException e) {
            errorMsg += "Le nombre de pages et le nombre de la page actuelle doivent être des nombres.";
//            if(request.getAttribute("n") == null) {
//                n = 5;
//            }
//            if(request.getAttribute("pageNb") == null) {
//                pageNb = 1;
//            }
        }

        request.setAttribute("errorMsg", errorMsg);

        if(errorMsg.isEmpty()) {
            request.setAttribute("n", n);
            request.setAttribute("pageNb", pageNb);


            int pageCount = (int)Math.ceil((double) livres.size() / n);
            int startIndex = ((pageNb-1) * n);
            int endIndex;
            if(pageNb < pageCount) {
                endIndex = startIndex + n;
            } else {
                endIndex = livres.size();
            }

            livresPaginated = livres.subList(startIndex, endIndex);
            request.setAttribute("pageCount", pageCount);
            request.setAttribute("livres", livresPaginated);
        }

        request.getRequestDispatcher("WEB-INF/bibliotheque/livresShow.jsp")
            .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
