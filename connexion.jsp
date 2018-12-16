<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page import="java.util.ArrayList" %> --%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <title>accueil</title>
</head>
<body>
  <h1>Site en construction</h1>
  <c:import url="/menu-invite.jsp"></c:import>

  <c:if test="${tentative}">
    <p>Pseudo ou mot de passe invalide !</p>
  </c:if>

  <form method="post" action="connexion">
    <p>
      <label for="pseudo">Pseudo : </label>
      <input type="text" name="pseudo" id="pseudo" />
    </p>
    <p>
      <label for="password">Password : </label>
      <input type="text" name="password" id="password" />
    </p>

      <input type="submit" />
  </form>

</body>
</html>
