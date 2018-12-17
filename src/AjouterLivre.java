import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;

@WebServlet("/ajouter-livre")
public class AjouterLivre extends HttpServlet {


  public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // On créer un objet Base
    Base base = new Base();

    // On créer un objet de validation
    StringValidation sv = new StringValidation();

    // On récupère les données du formulaire
    String titre = sv.valider(req.getParameter("titre"), 1, 100);
    String auteur = sv.valider(req.getParameter("auteur"), 1, 50);
    String editeur = sv.valider(req.getParameter("editeur"), 1, 50);
    String isbn = sv.valider(req.getParameter("isbn"), 0, 17);

    // Vérification des champs, si un champ est invalide on renvoi le formulaire
    if (titre == null || auteur == null || editeur == null || isbn == null) {
      req.setAttribute("tentative", true);
      req.setAttribute("titre", titre);
      req.setAttribute("auteur", auteur);
      req.setAttribute("editeur", editeur);
      req.setAttribute("isbn", isbn);
      this.getServletContext().getRequestDispatcher("/ajouter-livre.jsp").forward(req, resp);
    }

    // On execute la requette
    base.ajouterLivre(titre, auteur, editeur, isbn);

    // On transfert le resultat de la requette dans request
    // req.setAttribute("exemplaires", base.getDernierAjout(20));

    // On appel accueil.jsp
    this.getServletContext().getRequestDispatcher("/accueil").forward(req, resp);
  }
}
