<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
</html>
<html lang="fr">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Panier</title>
  </head>
  <body>
        <%@include file="menu.jsp" %>
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
            <h1>Panier</h1>
            <table border="0" style="border-collapse: collapse">
                <thead>
                   <tr>
                        <th style="padding:5px">Produit</th>
                        <th style="padding:5px">Prix</th>
                        <th style="padding:5px">Quantité</th>
                        <th></th>
                   </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${items}">
                        <c:if test="${item.value > 0}">
                        <tr>
                             <td style="padding:5px"> ${item.key.nom}</td>
                             <td style="padding:5px">
                                <fmt:formatNumber type="number"
                                    minFractionDigits="2" maxFractionDigits="2"
                                    value="${item.key.prix}"/> €
                             </td>
                             <td style="padding:5px"> ${item.value} </td>
                             <td>
                                <form action="panier" method="POST" style="display:inline-block">
                                    <input type="hidden" value="${item.key.id}" name="idRemoveSingleItem"/>
                                    <input type="submit" value=" - "/>
                                </form>
                                <form action="panier" method="POST" style="display:inline-block">
                                    <input type="hidden" value="${item.key.id}" name="idAddSingleItem"/>
                                    <input type="submit" value=" + "/>
                                </form>
                                <form action="panier" method="POST" style="display:inline-block">
                                    <input type="hidden" value="${item.key.id}" name="id"/>
                                    <input type="submit" value="Retirer"/>
                                </form>
                             </td>
                        </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
           </table>
           <div style="margin-top:20px">
               <c:if test="${!empty panier.items}">
                   <div><strong>Nombre items :</strong> ${totalItemsCount > 0 ? totalItemsCount : 0} </div>
                   <div> <strong>Prix Total :</strong>
                       <fmt:formatNumber type="number"
                            minFractionDigits="2" maxFractionDigits="2"
                            value="${total}"/> €
                   </div>
               </c:if>
               <c:if test="${empty panier.items}">
                    <p> Votre panier est vide. </p>
                </c:if>
           </div>
        </div>

  </body>
 </html>