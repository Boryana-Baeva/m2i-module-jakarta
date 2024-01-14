<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
</html>
<html lang="fr">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Age Evaluation Page</title>
  </head>
  <body>
        <form action="evaluationAge" method="POST">
            <label>Prénom </label>
            <input type="text" name="prenom" />
            <br>
            <label>Nom </label>
            <input type="text" name="nom" />
            <br>
            <label>Age </label>
            <input type="number" name="age" />
            <br>
            <input type="submit" value="Envoyer" />
        </form>
        <c:if test="${ isAgeValide }" >
            <div>
              <p>Vous vous appelez : ${prenom} ${nom}</p>

              <c:if test="${ isMajor }" >
                    <p>Et vous êtes une personne majeure.</p>
              </c:if>
              <c:if test="${ ! isMajor }" >
                    <p>Et vous êtes une personne mineure.</p>
              </c:if>
           </div>
        </c:if>
        <c:if test="${ isAgeValide == false  }" >
           <p>Le format de l'âge n'est pas valide !</p>
        </c:if>
  </body>
 </html>