<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
</html>
<html lang="fr">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Administration</title>
  </head>
  <body>
        <%@include file="menu.jsp" %>
        <div>
            <h1>New Product</h1>
            <form action="administration" method="POST">
                <div>
                    <label for="nom">Name </label>
                    <input type="text" id="nom" name="nom" value="${nom}" />
                </div>
                <div>
                    <label for="categories">Category </label>
                    <select name="categories" id="categories">
                          <c:forEach var="c" items="${categories}">
                                <option value="${c.id}">${c.nom}</option>
                          </c:forEach>
                    </select>
                </div>
                <div>
                    <label for="prix">Price </label>
                    <input type="number" id="prix" name="prix" value="${prix}"/>
                </div>
                <div>
                    <input type="submit" value="Add" />
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
            <h1>Products</h1>
            <table border="0" style="border-collapse: collapse">
                <thead>
                   <tr>
                        <th style="padding:5px">Product</th>
                        <th style="padding:5px">Category</th>
                        <th style="padding:5px">Price</th>
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
                        </tr>
                    </c:forEach>
                </tbody>
           </table>
        </div>



  </body>
 </html>