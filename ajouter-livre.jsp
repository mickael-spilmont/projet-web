<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <title>ajouter-livre</title>
</head>
<body>
  <c:import url="/menu.jsp"></c:import>

  <c:if test="${tentative}">
    <p>Un ou plusieurs champs sont incorrects</p>
  </c:if>

  <form method="post" action="ajouter-livre">
    <p>
      <label for="titre">Titre : </label>
      <input type="text" name="titre" <c:if test="${!empty titre}">value=${titre}</c:if> id="titre" />
    </p>
    <p>
      <label for="auteur">Auteur : </label>
      <input type="text" name="auteur" <c:if test="${!empty auteur}">value=${auteur}</c:if> id="auteur" />
    </p>
    <p>
      <label for="editeur">Editeur : </label>
      <input type="text" name="editeur" <c:if test="${!empty editeur}">value=${editeur}</c:if> id="editeur" />
    </p>
    <p>
      <label for="isbn">ISBN : </label>
      <input type="text" name="isbn" <c:if test="${!empty isbn}">value=${isbn}</c:if> id="isbn" />
    </p>

      <input type="submit" />
  </form>

</body>
</html>
