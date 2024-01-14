<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
</html>
<html lang="fr">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Rechercher des produits</title>
  </head>
  <body>
    <%@include file="menu.jsp" %>
    <div>
        <form action="search" method="POST">
            <input type="text" name="search" id="search" placeholder="Rechercher un produit par nom" />
            <input type="submit" value="Rechercher" />
        </form>
    </div>

    <c:if test="${errorMsg != null}">
            <p style="color:red">${errorMsg}<p>
    </c:if>

    <c:if test="${!empty searchResult}">
        <h1> Resultat </h1>
        <table border="0" style="border-collapse: collapse">
            <thead>
               <tr>
                    <th style="padding:5px">Nom</th>
                    <th style="padding:5px">Categorie</th>
                    <th style="padding:5px">Prix</th>
                    <th></th>
               </tr>
            </thead>
            <tbody>
                <c:forEach var="produit" items="${searchResult}">
                    <tr>
                         <td style="padding:5px">
                            <a href="./produit?id=${produit.id}" target="_blank"> ${produit.nom} </a>
                         </td>
                         <td style="padding:5px"> ${produit.categorie} </td>
                         <td style="padding:5px"> <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${produit.prix}"/> €</td>
                         <td style="padding:5px">
                            <form action="magasin" method="POST">
                                <input type="hidden" value="${produit.id}" name="id"/>
                                <input type="submit" value="Ajouter au panier"/>
                            </form>
                          </td>
                    </tr>
                </c:forEach>
            </tbody>
       </table>
    </c:if>

  </body>
 </html>