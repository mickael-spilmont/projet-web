import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;
import java.time.*;

@WebServlet("/accueil")
public class Accueil extends HttpServlet {


  public void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");
    PrintWriter out = resp.getWriter();

    try {
      // On déclare le type de driver JDBC et le chemin d’accès à la base, si pb exception ClassNotFound
      Class.forName("org.sqlite.JDBC");
      // String dbURL =  "jdbc:sqlite:/home/infoetu/spilmonm/TPs/Prog Web/tomcat8/webapps/projet/BDD/base.db";
      String dbURL =  "jdbc:sqlite:../../BDD/base.db";

      //On essaye de se connecter à la base
      Connection conn = DriverManager.getConnection(dbURL);
      if (conn != null) {
        out.println("Connected to the database");

        // un Statement est une interface qui représente une instruction SQL
        Statement stat = conn.createStatement();

        // le resultat du select est mis dans un ResultSet
        String requette = "SELECT e.id, e.date_exemplaire, l.titre, l.auteur, l.editeur, u.prenom, s.type ";
        requette += "FROM exemplaire AS e ";
        requette += "INNER JOIN livre AS l ON e.id_livre = l.id ";
        requette += "INNER JOIN utilisateur AS u ON e.id_util = u.id ";
        requette += "INNER JOIN status AS s ON e.id_status = s.id ";
        requette += "ORDER BY date_exemplaire DESC LIMIT 20;";
        ResultSet rs = stat.executeQuery(requette);

        ArrayList<Exemplaire> listeExemplaire = new ArrayList<>();
        while(rs.next()) {
          Exemplaire exemplaire = new Exemplaire();
          exemplaire.setId(rs.getInt("id"));
          exemplaire.setDate(rs.getString("date_exemplaire"));
          exemplaire.setTitre(rs.getString("titre"));
          exemplaire.setAuteur(rs.getString("auteur"));
          exemplaire.setEditeur(rs.getString("editeur"));
          exemplaire.setPrenom(rs.getString("prenom"));
          exemplaire.setType(rs.getString("type"));
          out.print(exemplaire.getId());
          listeExemplaire.add(exemplaire);
        }
        req.setAttribute("exemplaire", listeExemplaire);

        // On ferme les connexions au ResultSet, Statement et à la base
        rs.close();
        stat.close();
        conn.close();
      }
    }
    catch (ClassNotFoundException ex) {
      ex.printStackTrace();
      out.print("ClassNotFoundException");
    }
    catch (SQLException ex) {
      ex.printStackTrace();
      out.print("SQLException");
    }

    this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(req, resp);
  }
}
