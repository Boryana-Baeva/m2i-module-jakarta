<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
</html>
<html lang="fr">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Store</title>
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

        <c:if test="${empty errors}">
             <div>
                    <form action="product-search" method="POST">
                        <input type="text" name="search" id="search" placeholder="Rechercher un produit par nom" />
                        <input type="submit" value="Rechercher" />
                    </form>
                </div>

            <div style="margin-top:30px">
                <h1>Products</h1>
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
                        <c:forEach var="produit" items="${produits}">
                            <tr>
                                 <td style="padding:5px">
                                    <a href="./product?id=${produit.id}" target="_blank"> ${produit.nom} </a>
                                 </td>
                                 <td style="padding:5px"> ${produit.categorie} </td>
                                 <td style="padding:5px"> <fmt:formatNumber type="number"
                                  minFractionDigits="2" maxFractionDigits="2" value="${produit.prix}"/> €</td>
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
            </div>

        <div style="margin-top: 50px;margin-left:200px">
            <c:if test="${page > 1}">
                <a href="./store?page=${page-1}"> Previous <a>
            </c:if>
            <c:forEach var="i" begin="1" end="${pageCount}" step="1">
              <a href="./store?page=${i}">${ i }<a>
            </c:forEach>
            <c:if test="${page < pageCount}">
              <a href="./store?page=${page+1}"> Next <a>
            </c:if>
        </div>
    </c:if>

  </body>
 </html>