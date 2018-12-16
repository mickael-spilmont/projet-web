import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;
import java.time.*;

// import Exemplaire;

public class Base {
  private Connection connection;

  // Requette qui renvois les 'nbLivres' derniers exemplaire ajoutés
  public List<Exemplaire> getDernierAjout(int nbLivres) {
    List<Exemplaire> exemplaires = new ArrayList<>();

    // La requette est stockée dans une String
    String requette = "SELECT e.id, e.date_exemplaire, l.titre, l.auteur, l.editeur, u.pseudo, s.type ";
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
