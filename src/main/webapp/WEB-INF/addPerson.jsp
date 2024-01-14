<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
</html>
<html lang="fr">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Ajouter une personne</title>
  </head>
  <body>
        <div>
            <form action="addPerson" method="POST">
                <div>
                    <label>Prénom </label>
                    <input type="text" name="firstName" />
                </div>
                <div>
                    <label>Nom </label>
                    <input type="text" name="lastName" />
                </div>
                <div>
                    <label>Numéro de téléphone </label>
                    <input type="text" name="phoneNumber" />
                </div>
                <div>
                    <label>Adresse  </label>
                    <input type="text" name="address" />
                </div>
                <div>
                    <label>VIP  </label>
                    <input type="checkbox" name="isVIP" />
                </div>
                <div>
                    <input type="submit" value="Ajouter" />
                </div>
            </form>
        </div>
       <br>
        <div>
            <a href="./vip">VIP</a>
            <a href="./showPersons">Non VIP</a>
        </div>

        <div>
            <h1> Liste de toutes les personnes </h1>
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
                    <c:forEach var="person" items="${allPersons}">
                        <tr>
                             <td> ${person.firstName} </td>
                             <td> ${person.lastName} </td>
                             <td> ${person.phoneNumber} </td>
                             <td> ${person.address} </td>
                        </tr>
                    </c:forEach>
                </tbody>
           </table>
        </div>
  </body>
 </html>