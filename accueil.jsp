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

  <c:forEach items="${exemplaire}" var="temp">
        ${temp.date}, ${temp.titre}, ${temp.auteur}, ${temp.editeur}, ${temp.prenom}, ${temp.type} <br />
  </c:forEach>

</body>
</html>
