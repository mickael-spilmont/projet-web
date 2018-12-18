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

  <h2>${sessionScope.utilisateur.pseudo}</h2>
  <p>
    Prenom : ${sessionScope.utilisateur.prenom}</br>
    Nom : ${sessionScope.utilisateur.nom}</br>
    Date de naissance : ${sessionScope.utilisateur.dateNaissance}</br>
    Mail : ${sessionScope.utilisateur.mail}</br>
  </p>
  <c:choose>
    <c:when test="${invalide}">Le mot de passe est invalide !</c:when>
    <c:when test="${valide}">Le mot de passe à bien été changé</c:when>
  </c:choose>
  <form method="post" action="profil">
    <p>
      <input type="hidden" name="id" id="id" value="${sessionScope.utilisateur.id}">
    <p>
      <label for="password">Changer le mot de passe (entre 8 et 20) : </label>
      <input type="password" name="password" id="password" />&nbsp&nbsp&nbsp<input type="submit" />
    </p>
  </form>

</body>
</html>
