package com.demo.bibliotheque.controller;

import com.demo.bibliotheque.metier.GestionnaireLivres;
import com.demo.bibliotheque.metier.Livre;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Formatter;

@WebServlet("/livres-search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestionnaireLivres gestionnaireLivres = GestionnaireLivres.getGestionnaireLivres();
        request.setAttribute("livres", gestionnaireLivres.getLivres());

        request.getRequestDispatcher("WEB-INF/bibliotheque/livresSearch.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestionnaireLivres gestionnaireLivres = GestionnaireLivres.getGestionnaireLivres();
        String searchQuery = request.getParameter("search");

        ArrayList<Livre> searchResult = gestionnaireLivres.searchLivres(searchQuery);

        if(!searchResult.isEmpty() && !searchQuery.isBlank()) {
            request.setAttribute("searchResult", searchResult);
        } else  {
            request.setAttribute("errorMsg", "Aucun resultat trouvé pour «" + searchQuery + "».");
        }

        // Historique des recherches
        ArrayList<String> searches = (ArrayList<String>)request.getSession().getAttribute("searches");
        if(searches == null) {
            searches = new ArrayList<String>();
        }
        searches.add("«" + searchQuery + "»" +
                " à " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        request.getSession().setAttribute("searches", searches);

        doGet(request, response);
    }
}
