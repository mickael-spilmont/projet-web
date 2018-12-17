import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;

@WebServlet("/ajouter-livre")
public class AjouterLivre extends HttpServlet {


  public void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
    // On créer un objet Base
    Base base = new Base();

    // On récupère les données du formulaire
    String titre = req.getParameter("titre");
    String auteur = req.getParameter("auteur");
    String editeur = req.getParameter("editeur");
    String isbn = req.getParameter("isbn");

    // On execute la requette
    base.ajouterLivre(titre, auteur, editeur, isbn);

    // On transfert le resultat de la requette dans request
    // req.setAttribute("exemplaires", base.getDernierAjout(20));

    // On appel accueil.jsp
    this.getServletContext().getRequestDispatcher("/accueil").forward(req, resp);
  }
}
