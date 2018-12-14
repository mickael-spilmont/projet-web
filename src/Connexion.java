import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;
import java.time.*;

@WebServlet("/connexion")
public class Connexion extends HttpServlet {
  public void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");
    PrintWriter out = resp.getWriter();

    String mail = req.getParameter("mail");
    String password = req.getParameter("password");

    HttpSession session = req.getSession();

    try {
      Class.forName("org.sqlite.JDBC");
      String dbURL =  "jdbc:sqlite:../../BDD/base.db";
      Connection conn = DriverManager.getConnection(dbURL);

      if (conn != null) {
        Statement stat = conn.createStatement();
        String requette = "SELECT id, rang FROM utilisateur "
          + "WHERE mail = '" + mail + "' AND password = '" + password + "';";

        ResultSet rs = stat.executeQuery(requette);

        while (!rs.next()) {
          out.print("Adresse mail ou mot de passe invalide !");
        }
        // if (!rs.next()) {
        //   out.print("Adresse mail ou mot de passe invalide !");
        // }
        // else {
        //   int idJava =  rs.getInt("id");
        //   int rangJava = rs.getInt("rang");
        //
        //   out.print(rs.wasNull() + "</br>");
        //   out.print(idJava + "</br>" + rangJava + "</br>");
        // }

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
  }
}
