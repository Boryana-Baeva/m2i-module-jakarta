<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
</html>
<html lang="fr">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Ajouter des livres</title>
  </head>
  <body>

    <div style="margin:10px">
        <a href="./livres-search">Retour</a>
    </div>
    <div>
        <form action="livres-ajouter" method="POST">
            <div>
                <label for="titre">Titre </label>
                <input type="text" name="titre" id="titre" value="${titre}" />
            </div>
            <div>
                <label for="auteur">Auteur </label>
                <input type="text" name="auteur" id="auteur" value="${auteur}" />
            </div>
            <div>
                <label for="isbn">ISBN </label>
                <input type="text" name="isbn" id="isbn" value="${isbn}" />
            </div>
            <div>
                <input type="submit" value="Ajouter" />
            </div>
        </form>
    </div>


    <c:if test="${errorMsg != null}">
        <span style="color:red">${errorMsg}<span>
    </c:if>

  </body>
 </html>