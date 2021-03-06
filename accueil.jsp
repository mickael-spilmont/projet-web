<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <title>accueil</title>
</head>
<body>
  <c:import url="/menu.jsp"></c:import>

  <h2>Derniers ajouts</h2>
  <table>
      <tr>
        <th>Date d'ajout</th>
        <th>Titre</th>
        <th>Auteur</th>
        <th>Editeur</th>
        <th>Utilisateur</th>
        <th>Type d'ajout</th>
      </tr>

      <c:if test="${empty exemplaires}">
        exemplaire est vide
      </c:if>

      <c:forEach items="${exemplaires}" var="temp">
      <tr>
        <td>${temp.date} </td>
        <td>${temp.titre} </td>
        <td>${temp.auteur} </td>
        <td>${temp.editeur} </td>
        <td>${temp.pseudo} </td>
        <td>${temp.type} </td>
      </tr>
      </c:forEach>

  </table>

</body>
</html>
