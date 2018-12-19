<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <title>mes livres</title>
</head>
<body>
  <c:import url="/menu.jsp"></c:import>

  <h2>Mes livres</h2>
  <table>
      <tr>
        <th>Titre</th>
        <th>Auteur</th>
        <th>Editeur</th>
        <th>Date</th>
        <th>Type d'ajout</th>
      </tr>

      <c:forEach items="${exemplaires}" var="temp">
      <tr>
        <td>${temp.id} </td>
        <td>${temp.titre} </td>
        <td>${temp.auteur} </td>
        <td>${temp.editeur} </td>
        <td>${temp.date} </td>
        <td>${temp.type} </td>
      </tr>
      </c:forEach>

  </table>

</body>
</html>
