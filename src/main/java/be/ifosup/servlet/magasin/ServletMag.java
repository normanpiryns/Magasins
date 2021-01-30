package be.ifosup.servlet.magasin;

// ------------------------------------- imports ----------------------------------------------------

import be.ifosup.dao.DAOFactory;
import be.ifosup.magasin.Magasin;
import be.ifosup.magasin.MagasinDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletMag", urlPatterns = {"/mag"})
public class ServletMag extends HttpServlet {

    // -------------------------------------------- attributes -------------------------------------------

    private MagasinDAO magasinDAO;

    // -------------------------------------------- init method --------------------------------------------------------

    public void init() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.magasinDAO = daoFactory.getMagasinDAO();
    }

    // ---------------------------------------- doGet ----------------------------------------------------

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("vues/magasins.jsp").forward(request, response);
    }
}
