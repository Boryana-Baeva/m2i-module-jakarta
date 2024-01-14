<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
</html>
<html lang="fr">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Voitures</title>
  </head>
  <body>
        <form action="voitures" method="POST">
            <label>Nom </label>
            <input type="text" name="nom" />

            <label>Marque </label>
            <input type="text" name="marque" />

            <label>Immatriculation </label>
            <input type="text" name="immatriculation" />

            <label>Année </label>
            <input type="number" name="annee" />

            <input type="submit" value="Envoyer" />
        </form>

       <ul>
           <c:forEach items="${voitures}" var="voiture" >
                <li>${ voiture.nom } ${ voiture.marque } ${ voiture.immatriculation } ${ voiture.annee }</li>
           </c:forEach>
       </ul>

       <p>
           <c:if test="${errorMsg != null }" >
                ${errorMsg}
           </c:if>
       </p>

  </body>
 </html>