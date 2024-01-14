<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
</html>
<html lang="fr">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Plantes</title>
  </head>
  <body>
        <form action="plantes" method="POST">
            <label>Nom </label>
            <input type="text" name="nom" />

            <label>Espece </label>
            <input type="text" name="espece" />

            <label>Couleur </label>
            <input type="text" name="couleur" />

            <label>Age </label>
            <input type="number" name="age" />

            <input type="submit" value="Envoyer" />
        </form>

       <ul>
           <c:forEach items="${plantes}" var="plante" >
                <li>${ plante.nom } ${ plante.couleur }</li>
           </c:forEach>
       </ul>
  </body>
 </html>