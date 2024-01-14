<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
</html>
<html lang="fr">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Product Search</title>
  </head>
  <body>
    <%@include file="menu.jsp" %>
    <div>
        <form action="product-search" method="POST">
            <input type="text" name="search" id="search" placeholder="Search by product name" />
            <input type="submit" value="Search" />
        </form>
    </div>

    <c:if test="${errorMsg != null}">
            <p style="color:red">${errorMsg}<p>
    </c:if>

    <c:if test="${!empty searchResult}">
        <h1> Result </h1>
        <table border="0" style="border-collapse: collapse">
            <thead>
               <tr>
                    <th style="padding:5px">Product</th>
                    <th style="padding:5px">Category</th>
                    <th style="padding:5px">Price</th>
                    <th></th>
               </tr>
            </thead>
            <tbody>
                <c:forEach var="produit" items="${searchResult}">
                    <tr>
                         <td style="padding:5px">
                            <a href="./product?id=${produit.id}" target="_blank"> ${produit.nom} </a>
                         </td>
                         <td style="padding:5px"> ${produit.categorie} </td>
                         <td style="padding:5px">
                            <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2"
                                value="${produit.prix}"/> €
                         </td>
                         <td style="padding:5px">
                            <form action="store" method="POST">
                                <input type="hidden" value="${produit.id}" name="id"/>
                                <input type="submit" value="Add To Cart"/>
                            </form>
                          </td>
                    </tr>
                </c:forEach>
            </tbody>
       </table>
    </c:if>

  </body>
 </html>