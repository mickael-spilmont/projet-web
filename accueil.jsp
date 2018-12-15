<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <title>accueil</title>
</head>
<body>
  <h1>Site en construction</h1>
  <ul>
    <li><a href="toDo">Accueil </a></li>
    <li><a href="toDo">Mes livres </a></li>
    <li><a href="toDo">Ajouter des livres </a></li>
    <li><a href="toDo">Rechercher </a></li>
    <li><a href="toDo">Connexion </a></li>
  </ul>

  <p><c:out value="Bonjour !" /></p>

  <%-- <%
    ArrayList<String> noms = new ArrayList<>();
    noms = (ArrayList<String>)request.getAttribute("nom");
    if (noms != null) {
      for (String nom : noms) {
        out.print(nom + "</br>");
      }
    }
  %> --%>

  <c:forEach items="${utilisateur}" var="temp">
        ${temp.id} , ${temp.prenom}, ${temp.nom}, ${temp.dateNaissance}, ${temp.mail} <br />
  </c:forEach>

</body>
</html>
