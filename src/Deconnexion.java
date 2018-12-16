import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;
import java.time.*;

@WebServlet("/deconnexion")
public class Deconnexion extends HttpServlet {


  public void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
    // On appelle la session
    HttpSession session = req.getSession();
    session.invalidate();

    this.getServletContext().getRequestDispatcher("/accueil").forward(req, resp);
  }
}
