import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;

@WebServlet("/connexion")
public class Connexion extends HttpServlet {
  public void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
    // On appelle la session
    HttpSession session = req.getSession();

    // On crée un objet Base
    Base base = new Base();

    // On récupère les données du formulaire
    String pseudo = req.getParameter("pseudo");
    String password = req.getParameter("password");

    // On crée un objet utilisateur et on appelle la requette
    Utilisateur utilisateur = base.getConnexion(pseudo, password);

    // Si utilisateur est null (non trouvé dans la base), on rapelle connexion.jsp avec un message d'erreur
    if (utilisateur == null) {
      req.setAttribute("tentative", true);
      this.getServletContext().getRequestDispatcher("/connexion.jsp").forward(req, resp);
    }

    // Sinon on stock l'utilisateur dans la session et on le renvoie sur accueil
    session.setAttribute("utilisateur", utilisateur);
    this.getServletContext().getRequestDispatcher("/accueil").forward(req, resp);
  }
}
