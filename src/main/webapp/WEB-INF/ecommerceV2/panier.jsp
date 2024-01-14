<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
</html>
<html lang="fr">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Shopping Cart</title>
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
            <h1>Shopping Cart</h1>
            <table border="0" style="border-collapse: collapse">
                <thead>
                   <tr>
                        <th style="padding:5px">Product</th>
                        <th style="padding:5px">Price</th>
                        <th style="padding:5px">Quantity</th>
                        <th></th>
                   </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${items}">
                        <c:if test="${item.quantite > 0}">
                        <tr>
                             <td style="padding:5px"> ${item.produit.nom}</td>
                             <td style="padding:5px">
                                <fmt:formatNumber type="number"
                                    minFractionDigits="2" maxFractionDigits="2"
                                    value="${item.produit.prix}"/> €
                             </td>
                             <td style="padding:5px"> ${item.quantite} </td>
                             <td>
                                <form action="cart" method="POST" style="display:inline-block">
                                    <input type="hidden" value="${item.produit.id}" name="idRemoveSingleItem"/>
                                    <input type="submit" value=" - "/>
                                </form>
                                <form action="cart" method="POST" style="display:inline-block">
                                    <input type="hidden" value="${item.produit.id}" name="idAddSingleItem"/>
                                    <input type="submit" value=" + "/>
                                </form>
                                <form action="cart" method="POST" style="display:inline-block">
                                    <input type="hidden" value="${item.produit.id}" name="id"/>
                                    <input type="submit" value="Remove"/>
                                </form>
                             </td>
                        </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
           </table>
           <div style="margin-top:20px">
               <c:if test="${!empty panier.items && panier.totalItemsCount > 0}">
                   <div><strong>Items count:</strong> ${totalItemsCount} </div>
                   <div> <strong>Total Price :</strong>
                       <fmt:formatNumber type="number"
                            minFractionDigits="2" maxFractionDigits="2"
                            value="${total}"/> €
                   </div>
               </c:if>
               <c:if test="${empty panier.items || panier.totalItemsCount == 0}">
                    <p> Your shopping cart is empty </p>
                </c:if>
           </div>
        </div>

  </body>
 </html>