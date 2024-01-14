<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
</html>
<html lang="fr">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Rechercher des livres</title>
  </head>
  <body>
    <div style="margin:10px">
        <a href="./livres-ajouter">Ajouter un livre</a>
        <a href="./livres-show?n=5&pageNb=1">Voir la liste des livres</a>
    </div>

    <div>
        <form action="livres-search" method="POST">
            <input type="text" name="search" id="search" placeholder="Rechercher une livre par titre ou oar auteur" />
            <input type="submit" value="Rechercher" />
        </form>
    </div>

    <c:if test="${!empty searchResult}">
        <ul>
            <c:forEach var="livre" items="${searchResult}">
                <li> ${livre.titre}, ${livre.auteur} ISBN ${livre.isbn} </li>
            </c:forEach>
        </ul>
    </c:if>

    <c:if test="${errorMsg != null}">
        <p style="color:red">${errorMsg}<p>
    </c:if>

    <h1> Historique des recherches </h1>
    <ul>
        <c:forEach var="search" items="${searches}">
            <li> ${search} </li>
        </c:forEach>
    </ul>
    <h1> Tous les livres </h1>
    <ul>
        <c:forEach var="livre" items="${livres}">
            <li> ${livre.titre}, ${livre.auteur} ISBN ${livre.isbn} </li>
                <span>
                    <form action="livres-modifier" method="GET">
                        <input type="hidden" name="isbn" value="${livre.isbn}"/>
                        <input type="submit" value="Modifier"/>
                    </form>
                 </span>
        </c:forEach>
    </ul>


  </body>
 </html>