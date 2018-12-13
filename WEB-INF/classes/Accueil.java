import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/")
public class Accueil extends HttpServlet {
  public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
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
    out.println("</body>");
    out.println("</html>");
  }

  public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
    // Todo
  }
}
