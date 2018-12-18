import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;

@WebServlet("/profil")
public class Profil extends HttpServlet {

  public void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
    // On créer un objet Base
    Base base = new Base();

    // On créer un objet de validation
    StringValidation sv = new StringValidation();

    // On créer un booleen qui passera sur true en cas d'anomalie
    boolean erreur = false;

    // On récupère les données du formulaire
    int id = Integer.parseInt(req.getParameter("id"));
    String password = sv.valider(req.getParameter("password"), 8, 20);

    // Vérification des champs, si un champ est invalide on renvoi le formulaire
    if (password == null) {
      req.setAttribute("invalide", true);
      this.getServletContext().getRequestDispatcher("/profil.jsp").forward(req, resp);
    }
    else {
      // On execute la requette
      base.setPassword(id, password);
      req.setAttribute("valide", true);
      this.getServletContext().getRequestDispatcher("/profil.jsp").forward(req, resp);
    }
  }
}
