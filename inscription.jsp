<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <title>inscription</title>
</head>
<body>
  <c:import url="/menu.jsp"></c:import>

  <c:if test="${tentative}">
    <p>Un ou plusieurs champs sont incorrects</p>
  </c:if>

  <form method="post" action="inscription">
    <p>
      <c:if test="${wrongPseudo}">Ce pseudo est déja utilisé</br></c:if>
      <label for="pseudo">Pseudo : </label>
      <input type="text" name="pseudo" <c:if test="${!empty pseudo}">value=${pseudo}</c:if> id="pseudo" />
    </p>
    <p>
      <label for="prenom">Prenom : </label>
      <input type="text" name="prenom" <c:if test="${!empty prenom}">value=${prenom}</c:if> id="prenom" />
    </p>
    <p>
      <label for="nom">Nom : </label>
      <input type="text" name="nom" <c:if test="${!empty nom}">value=${nom}</c:if> id="nom" />
    </p>
    <p>
      <label for="date">Date : </label>
      <input type="date" name="date" <c:if test="${!empty date}">value=${date}</c:if> id="date" />
    </p>
    <p>
      <c:if test="${wrongPseudo}">Ce mail est invalide ou déja utilisé</br></c:if>
      <label for="mail">Mail : </label>
      <input type="text" name="mail" <c:if test="${!empty mail}">value=${mail}</c:if> id="mail" />
    </p>
    <p>
      <label for="password">Mot de passe (entre 8 et 20) : </label>
      <input type="password" name="password" id="password" />
    </p>


      <input type="submit" />
  </form>

</body>
</html>
