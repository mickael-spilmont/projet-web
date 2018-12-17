<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <title>accueil</title>
</head>
<body>
  <h1>Site en construction</h1>
  <c:import url="/menu-invite.jsp"></c:import>

  <%-- <c:if test="${tentative}">
    <p>Pseudo ou mot de passe invalide !</p>
  </c:if> --%>

  <form method="post" action="ajouter-livre">
    <p>
      <label for="titre">Titre : </label>
      <input type="text" name="titre" id="titre" />
    </p>
    <p>
      <label for="auteur">Auteur : </label>
      <input type="text" name="auteur" id="auteur" />
    </p>
    <p>
      <label for="editeur">Editeur : </label>
      <input type="text" name="editeur" id="editeur" />
    </p>
    <p>
      <label for="isbn">ISBN : </label>
      <input type="text" name="isbn" id="isbn" />
    </p>

      <input type="submit" />
  </form>

</body>
</html>
