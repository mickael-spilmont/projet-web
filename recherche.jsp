<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <title>ajouter livre</title>
</head>
<body>
  <c:import url="/menu.jsp"></c:import>

  <c:if test="${tentative}">
    <p>Un ou plusieurs champs sont incorrects</p>
  </c:if>

  <form method="post" action="recherche">
    <p>
      <label for="critere">Recherche : </label>
      <input type="text" name="critere" id="critere" />
    </p>

      <input type="submit" />
  </form>

  <table>
      <tr>
        <th>Titre</th>
        <th>Auteur</th>
        <th>Editeur</th>
        <th>Isbn</th>
      </tr>

      <c:forEach items="${livres}" var="temp">
      <tr>
        <td>${temp.titre} </td>
        <td>${temp.auteur} </td>
        <td>${temp.editeur} </td>
        <td>${temp.isbn} </td>
      </tr>
      </c:forEach>

  </table>

</body>
</html>
