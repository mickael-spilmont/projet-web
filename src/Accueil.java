import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;

@WebServlet("/accueil")
public class Accueil extends HttpServlet {


  public void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
    // On créer un objet Base
    Base base = new Base();
    // On transfert le resultat de la requette dans request
    req.setAttribute("exemplaire", base.getDernierAjout(20));

    // On appel accueil.jsp
    this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(req, resp);
  }
}
