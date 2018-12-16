import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;
import java.time.*;

@WebServlet("/mes-livres")
public class MesLivres extends HttpServlet {
  public void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");
    PrintWriter out = resp.getWriter();

    // Appel de la session
    HttpSession session = req.getSession();

    // On vérifie si un utilisateur est logué, dans le cas contraire on retourne la page de connexion
    if (session.getAttribute(utilisateur) == null) {
      this.getServletContext().getRequestDispatcher("/connexion.jsp").forward(req, resp);
    }

    // On vas chercher les livres de l'utilisateur dans la database
    
  }
}
