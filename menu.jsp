<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page import="java.util.ArrayList" %> --%>
<h1>Site en construction</h1>
<c:choose>
  <c:when test="${!empty sessionScope.utilisateur  && sessionScope.utilisateur.rang==10}">
    <ul>
        <li><a href="accueil">Accueil </a></li>
        <li><a href="mes-livres">Mes livres </a></li>
        <li><a href="ajouter-livre.jsp">Ajouter des livres </a></li>
        <li><a href="recherche.jsp">Rechercher </a></li>
        <li><a href="ToDo">Administration </a></li>
        <li><a href="profil.jsp">${sessionScope.utilisateur.pseudo} </a></li>
        <li><a href="deconnexion">Deconnexion </a></li>
    </ul>
  </c:when>
  <c:when test="${!empty sessionScope.utilisateur && sessionScope.utilisateur.rang==1}">
    <ul>
      <li><a href="accueil">Accueil </a></li>
      <li><a href="mes-livres">Mes livres </a></li>
      <li><a href="ajouter-livre.jsp">Ajouter des livres </a></li>
      <li><a href="recherche.jsp">Rechercher </a></li>
      <li><a href="profil.jsp">${sessionScope.utilisateur.pseudo} </a></li>
      <li><a href="deconnexion">Deconnexion </a></li>
    </ul>
  </c:when>
  <c:otherwise>
    <ul>
      <li><a href="accueil">Accueil </a></li>
      <li><a href="connexion.jsp">Mes livres </a></li>
      <li><a href="connexion.jsp">Ajouter des livres </a></li>
      <li><a href="recherche.jsp">Rechercher </a></li>
      <li><a href="inscription.jsp">Inscription </a></li>
      <li><a href="connexion.jsp">Connexion </a></li>
    </ul>
  </c:otherwise>
</c:choose>
