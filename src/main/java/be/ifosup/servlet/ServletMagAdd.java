package be.ifosup.servlet;

// ----------------------------------------- imports ------------------------------------------------------------------

import be.ifosup.dao.DAOFactory;
import be.ifosup.magasin.Magasin;
import be.ifosup.magasin.MagasinDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletMagAdd", urlPatterns = {"/magadd"})

public class ServletMagAdd extends HttpServlet {

    // ------------------------------------------- Attributes ---------------------------------------------------------

    private MagasinDAO magasinDAO;


    // -------------------------------------------- init method --------------------------------------------------------

    public void init() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.magasinDAO = daoFactory.getMagasinDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/magAdd.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




        // ---------------------- UTF-8 forcing ----------------------------

        request.setCharacterEncoding("UTF-8");

        // ----------------------- getParameters ---------------------------
        String titre = request.getParameter("cat");


        // ------------------------add to the db ---------------------------

        try {
            magasinDAO.ajouter( new Magasin(titre) );



        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            request.setAttribute("mag", magasinDAO.listMag());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // ---------------------- redirection -----------------------------------------

        request.getRequestDispatcher("views/magAdd.jsp").forward(request, response);
    }
}
