import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;
import java.time.*;

// Classe qui gère tout les accès à la base de données
public class Base {
  private Connection connection;

  // Requette qui renvois les 'nbLivres' derniers exemplaire ajoutés
  public List<Exemplaire> getDernierAjout(int nbLivres) {
    List<Exemplaire> exemplaires = new ArrayList<>();

    // La requette est stockée dans une String
    String requette = "SELECT e.id, l.id, u.id, e.date_exemplaire, l.titre, l.auteur, l.editeur, u.pseudo, s.type ";
    requette += "FROM exemplaire AS e ";
    requette += "INNER JOIN livre AS l ON e.id_livre = l.id ";
    requette += "INNER JOIN utilisateur AS u ON e.id_util = u.id ";
    requette += "INNER JOIN status AS s ON e.id_status = s.id ";
    requette += "ORDER BY date_exemplaire DESC LIMIT " + nbLivres + ";";

    loadDataBase();

    try {
      Statement statement = connection.createStatement();
      ResultSet resultset = statement.executeQuery(requette);

      while(resultset.next()) {
        Exemplaire exemplaire = new Exemplaire();
        exemplaire.setId(resultset.getInt("id"));
        exemplaire.setIdLivre(resultset.getInt(2));
        exemplaire.setIdUtilisateur(resultset.getInt(3));
        exemplaire.setDate(resultset.getString("date_exemplaire"));
        exemplaire.setTitre(resultset.getString("titre"));
        exemplaire.setAuteur(resultset.getString("auteur"));
        exemplaire.setEditeur(resultset.getString("editeur"));
        exemplaire.setPseudo(resultset.getString("pseudo"));
        exemplaire.setType(resultset.getString("type"));
        exemplaires.add(exemplaire);
      }

      // Fermeture de resultset, statement, connexion
      resultset.close();
      statement.close();
      connection.close();
    }
    catch (SQLException ex){
      ex.printStackTrace();
    }

    // On retourne le resultat
    return exemplaires;
  }

  // Requette qui affiche un utilisateur en fonction de pseudo et de son login (sert pour Connexion.java)
  public Utilisateur getConnexion(String pseudo, String password) {
    Utilisateur utilisateur = new Utilisateur();

    String requette = "SELECT * FROM utilisateur ";
    requette += "WHERE pseudo = '" + pseudo + "' AND password = '" + password + "';";

    loadDataBase();

    try {
      Statement statement = connection.createStatement();
      ResultSet resultset = statement.executeQuery(requette);

      if (!resultset.next()) {
        utilisateur = null;
      }
      else {
        utilisateur.setId(resultset.getInt("id"));
        utilisateur.setPseudo(resultset.getString("pseudo"));
        utilisateur.setPrenom(resultset.getString("prenom"));
        utilisateur.setNom(resultset.getString("nom"));
        utilisateur.setDateNaissance(resultset.getString("date_naissance"));
        utilisateur.setMail(resultset.getString("mail"));
        utilisateur.setRang(resultset.getInt("rang"));
      }

      resultset.close();
      statement.close();
      connection.close();
    }
    catch (SQLException ex){
      ex.printStackTrace();
    }
    return utilisateur;
  }

  // Liste tout les livres possédé par un utilisateur
  public List<Exemplaire> getLivresUtilisateur(int id) {
    List<Exemplaire> exemplaires = new ArrayList<>();

    // La requette est stockée dans une String
    String requette = "SELECT e.id, l.titre, l.auteur, l.editeur, e.date_exemplaire, s.type ";
    requette += "FROM exemplaire AS e ";
    requette += "INNER JOIN livre AS l ON e.id_livre = l.id ";
    requette += "INNER JOIN utilisateur AS u ON e.id_util = u.id ";
    requette += "INNER JOIN status AS s ON e.id_status = s.id ";
    requette += "WHERE u.id = " + id + " ";
    requette += "ORDER BY titre ASC;";

    loadDataBase();

    try {
      Statement statement = connection.createStatement();
      ResultSet resultset = statement.executeQuery(requette);

      while(resultset.next()) {
        Exemplaire exemplaire = new Exemplaire();
        exemplaire.setId(resultset.getInt("id"));
        exemplaire.setTitre(resultset.getString("titre"));
        exemplaire.setAuteur(resultset.getString("auteur"));
        exemplaire.setEditeur(resultset.getString("editeur"));
        exemplaire.setDate(resultset.getString("date_exemplaire"));
        exemplaire.setType(resultset.getString("type"));
        exemplaires.add(exemplaire);
      }

      // Fermeture de resultset, statement, connexion
      resultset.close();
      statement.close();
      connection.close();
    }
    catch (SQLException ex){
      ex.printStackTrace();
    }

    // On retourne le resultat
    return exemplaires;
  }

  // Méthode qui retourne un utilisateur en fonction de son login et de son Mail
  public Utilisateur getUtilisateur(String pseudo, String mail) {
    Utilisateur utilisateur = new Utilisateur();

    // La requette est stockée dans une String
    String requette = "SELECT pseudo, mail FROM utilisateur ";
    requette += "WHERE pseudo = '" + pseudo + "' OR mail = '" + mail + "';";

    loadDataBase();

    try {
      Statement statement = connection.createStatement();
      ResultSet resultset = statement.executeQuery(requette);

      if (!resultset.next()) {
        utilisateur = null;
      }
      else {
        utilisateur.setPseudo(resultset.getString("pseudo"));
        utilisateur.setMail(resultset.getString("mail"));
      }

      // Fermeture de resultset, statement, connexion
      resultset.close();
      statement.close();
      connection.close();
    }
    catch (SQLException ex){
      ex.printStackTrace();
    }

    // On retourne le resultat
    return utilisateur;
  }

  // Méthode d'ajout d'un livres
  public void ajouterLivre(String titre, String auteur, String editeur, String isbn) {
    // La requette est stockée dans une String
    String requette = "INSERT INTO livre (titre, auteur, editeur, isbn) VALUES ";
    requette += "('" + titre + "', '" + auteur + "', '" + editeur + "', '" + isbn + "');";

    loadDataBase();

    try {
      Statement statement = connection.createStatement();
      ResultSet resultset = statement.executeQuery(requette);

      // Fermeture de resultset, statement, connexion
      resultset.close();
      statement.close();
      connection.close();
    }
    catch (SQLException ex){
      ex.printStackTrace();
    }
  }

  // Méthode d'ajout d'un utilisateur
  public void ajouterUtilisateur(String pseudo, String prenom, String nom, String date, String mail, String password) {
    // La requette est stockée dans une String
    String requette = "INSERT INTO utilisateur (pseudo, prenom, nom, date_naissance, mail, password) VALUES ";
    requette += "('" + pseudo + "', '" + prenom + "', '" + nom + "', '" + date + "', '" + mail + "', '" + password + "');";

    loadDataBase();

    try {
      Statement statement = connection.createStatement();
      ResultSet resultset = statement.executeQuery(requette);

      // Fermeture de resultset, statement, connexion
      resultset.close();
      statement.close();
      connection.close();
    }
    catch (SQLException ex){
      ex.printStackTrace();
    }
  }

  // Méthode qui permet de se connecter à la base
  private void loadDataBase() {
    try {
      Class.forName("org.sqlite.JDBC");
      connection = DriverManager.getConnection("jdbc:sqlite:../../BDD/base.db");
    }
    catch (ClassNotFoundException ex) {
      ex.printStackTrace();
    }
    catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
