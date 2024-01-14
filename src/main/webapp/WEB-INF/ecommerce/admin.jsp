<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
</html>
<html lang="fr">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Admin Panel</title>
  </head>
  <body>
        <%@include file="menu.jsp" %>
        <div>
            <h1>Nouveau Produit</h1>
            <form action="admin" method="POST">
                <div>
                    <label>Nom </label>
                    <input type="text" name="nom" value="${nom}" />
                </div>
                <div>
                    <label>Categorie </label>
                    <input type="text" name="categorie" value="${categorie}"/>
                </div>
                <div>
                    <label>Prix </label>
                    <input type="number" name="prix" value="${prix}"/>
                </div>
                <div>
                    <input type="submit" value="Ajouter" />
                </div>
            </form>
        </div>

        <div>
            <c:if test="${!empty errors}">
                <ul>
                    <c:forEach var="error" items="${errors}">
                        <li style="color:red">${error}</li>
                    </c:forEach>
                </ul>
            </c:if>
        </div>

        <div style="margin-top:30px">
            <h1>Produits</h1>
            <table border="0" style="border-collapse: collapse">
                <thead>
                   <tr>
                        <th style="padding:5px">Nom</th>
                        <th style="padding:5px">Categorie</th>
                        <th style="padding:5px">Prix</th>
                   </tr>
                </thead>
                <tbody>
                    <c:forEach var="produit" items="${produits}">
                        <tr>
                             <td style="padding:5px">
                             <a href="./produit?id=${produit.id}" target="_blank"> ${produit.nom} </a>
                             </td>
                             <td style="padding:5px"> ${produit.categorie} </td>
                             <td style="padding:5px"> <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${produit.prix}"/> €</td>
                        </tr>
                    </c:forEach>
                </tbody>
           </table>
        </div>



  </body>
 </html>