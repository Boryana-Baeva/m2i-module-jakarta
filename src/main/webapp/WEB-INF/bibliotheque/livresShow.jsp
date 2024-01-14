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
        <a href="./livres-search">Rechercher</a>
    </div>

    <c:if test="${!empty errorMsg}">
            <p style="color:red">${errorMsg}<p>
    </c:if>

    <h1> Bibliotheque </h1>

    <div>
        <c:if test="${pageNb > 1}">
            <a href="./livres-show?n=${n}&pageNb=${pageNb-1}"> Previous <a>
        </c:if>
        <c:forEach var="i" begin="1" end="${pageCount}" step="1">
          <a href="./livres-show?n=${n}&pageNb=${i}">${ i }<a>
        </c:forEach>
        <c:if test="${pageNb < pageCount}">
          <a href="./livres-show?n=${n}&pageNb=${pageNb+1}"> Next <a>
        </c:if>
    </div>

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