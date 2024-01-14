<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
</html>
<html lang="fr">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Personnes</title>
  </head>
  <body>
    <h1> Liste des personnes <c:if test="${ !isVIP }">non</c:if> VIP</h1>
       <table border="1px">
            <thead>
               <tr>
                    <th>Prénom</th>
                    <th>Nom</th>
                    <th>Numéro de téléphone</th>
                    <th>Adresse</th>
               </tr>
            </thead>
            <tbody>
                <c:forEach var="person" items="${listPersons}">
                    <tr>
                         <td> ${person.firstName} </td>
                         <td> ${person.lastName} </td>
                         <td> ${person.phoneNumber} </td>
                         <td> ${person.address} </td>
                    </tr>
                </c:forEach>
            </tbody>
       </table>

  </body>
 </html>