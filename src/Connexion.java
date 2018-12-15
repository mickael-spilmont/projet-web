import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;

@WebServlet("/connexion")
public class Connexion extends HttpServlet {
  public void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");
    PrintWriter out = resp.getWriter();

    // On appelle la session
    HttpSession session = req.getSession();

    // On récupère les données du formulaire
    String pseudo = req.getParameter("pseudo");
    String password = req.getParameter("password");

    try {
      Class.forName("org.sqlite.JDBC");
      String dbURL =  "jdbc:sqlite:../../BDD/base.db";
      Connection conn = DriverManager.getConnection(dbURL);

      if (conn != null) {
        out.println("Connected to the database");
        Statement stat = conn.createStatement();
        String requette = "SELECT * FROM utilisateur "
          + "WHERE pseudo = '" + pseudo + "' AND password = '" + password + "';";

        ResultSet rs = stat.executeQuery(requette);

        if (!rs.next()) {
          req.setAttribute("tentative", true);
        }
        else {
          Utilisateur utilisateur = new Utilisateur();
          utilisateur.setId(rs.getInt("id"));
          utilisateur.setPseudo(rs.getString("pseudo"));
          utilisateur.setPrenom(rs.getString("prenom"));
          utilisateur.setNom(rs.getString("nom"));
          utilisateur.setDateNaissance(rs.getString("date_naissance"));
          utilisateur.setMail(rs.getString("mail"));
          utilisateur.setRang(rs.getInt("rang"));

          session.setAttribute("utilisateur", utilisateur);
        }

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

    this.getServletContext().getRequestDispatcher("/accueil").forward(req, resp);
  }
}
