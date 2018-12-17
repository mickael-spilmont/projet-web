import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;

@WebServlet("/inscription")
public class Inscription extends HttpServlet {

  public void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
    // On créer un objet Base
    Base base = new Base();

    // On créer un objet de validation
    StringValidation sv = new StringValidation();

    // On créer un booleen qui passera sur true en cas d'anomalie
    boolean erreur = false;

    // On récupère les données du formulaire
    String pseudo = sv.valider(req.getParameter("pseudo"), 1, 15);
    String prenom = sv.valider(req.getParameter("prenom"), 1, 50);
    String nom = sv.valider(req.getParameter("nom"), 1, 50);
    String date = sv.valider(req.getParameter("date"), 1, 15);
    String mail = sv.valider(req.getParameter("mail"), 3, 50);
    String password = sv.valider(req.getParameter("password"), 8, 20);

    // Vérification des champs, si un champ est invalide on renvoi le formulaire
    if (pseudo == null || prenom == null || nom == null || date == null || mail == null || password == null) {
      erreur = true;
      req.setAttribute("pseudo", pseudo);
      req.setAttribute("prenom", prenom);
      req.setAttribute("nom", nom);
      req.setAttribute("date", date);
      req.setAttribute("mail", mail);
      req.setAttribute("password", password);
    }

    // On vérifie si l'utilisateur existe déja, on invalide les infos eronées et on renvoi le formulaire
    Utilisateur utilisateur = base.getUtilisateur(pseudo, mail);
    if (utilisateur != null && pseudo.equals(utilisateur.getPseudo())) {
      erreur = true;
      req.setAttribute("wrongPseudo", true);
      req.setAttribute("pseudo", null);
    }
    if (utilisateur != null && mail.equals(utilisateur.getMail())) {
      erreur = true;
      req.setAttribute("wrongMail", true);
      req.setAttribute("mail", null);
    }

    if (erreur) {
      this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(req, resp);
    }
    else {
      // On execute la requette
      base.ajouterUtilisateur(pseudo, prenom, nom, date, mail, password);
      // On appel accueil.jsp
      this.getServletContext().getRequestDispatcher("/accueil").forward(req, resp);
    }
  }
}
