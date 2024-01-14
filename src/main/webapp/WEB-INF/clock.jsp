<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Hello World! JSP</h1>
    <p>${ hour }</p>

    <c:if test="${ ilFaitJour }">
    <p>Bonjour ! </p>
    </c:if>

    <c:if test="${ ! ilFaitJour }">
    <p>Bonne nuit ! </p>
    </c:if>

    <p>Voici les jours de la semaine: </p>

    <table>
        <c:forEach var="jour" items="${jours}">
            <tr><td> ${jour} </td></tr>
        </c:forEach>
    </table>
  </body>
</html>