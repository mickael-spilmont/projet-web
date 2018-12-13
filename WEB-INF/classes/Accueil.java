import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;
import java.time.*;

@WebServlet("/")
public class Accueil extends HttpServlet {
  public void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");

    PrintWriter out = resp.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"utf-8\" />");
    out.println("<title>Accueil</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>Bienvenue<h1>");
    out.println("<ul>");
    out.println(" <li><a href=\"todo\">Accueil </a></li>");
    out.println(" <li><a href=\"todo\">Mes Livres </a></li>");
    out.println(" <li><a href=\"todo\">Ajouter des livres </a></li>");
    out.println(" <li><a href=\"todo\">Rechercher </a></li>");
    out.println(" <li><a href=\"todo\">Connexion </a></li>");
    out.println("</ul>");

    try {
      // On déclare le type de driver JDBC et le chemin d’accès à la base, si pb exception ClassNotFound
      Class.forName("org.sqlite.JDBC");
      String dbURL = "jdbc:sqlite:../webapps/projet/base.db";

      //On essaye de se connecter à la base
      Connection conn = DriverManager.getConnection(dbURL);
      if (conn != null) {
        out.println("Connected to the database");

        // un Statement est une interface qui représente une instruction SQL
        Statement stat = conn.createStatement();

        // le resultat du select est mis dans un ResultSet
        String requette = "SELECT * FROM utilisateur;";
        ResultSet rs = stat.executeQuery(requette);

        while (rs.next()) {
          int idJava = rs.getInt("id");
          String prenomJava = rs.getString("prenom");
          String nomJava = rs.getString("nom");
          LocalDate dateJava = rs.getDate("date_naissance").toLocalDate();
          String mailJava = rs.getString("mail");
          int rangJava = rs.getInt("rang");
          String passwordJava = rs.getString("password");

          out.print(idJava + prenomJava + nomJava + dateJava + mailJava + rangJava + passwordJava);
        }

        // On ferme les connexions au ResultSet, Statement et à la base
        rs.close();
        stat.close();
        conn.close();
      }
    }
    catch (ClassNotFoundException ex) {
      ex.printStackTrace();
    }
    catch (SQLException ex) {
      ex.printStackTrace();
    }

    out.println("</body>");
    out.println("</html>");
  }
}
