import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;

@WebServlet("/recherche")
public class Rechercher extends HttpServlet {
  public void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
    // On crée un objet Base
    Base base = new Base();

    // On créer un objet de validation
    StringValidation sv = new StringValidation();

    // On récupère les données du formulaire
    String critere = sv.valider(req.getParameter("critere"), 1, 100);

    if (critere != null) {
      req.setAttribute("livres", base.recherche(critere));
    }

    this.getServletContext().getRequestDispatcher("/recherche.jsp").forward(req, resp);
  }
}
