package be.ifosup.servlet.magasin;

// ----------------------------------------- imports ------------------------------------------------------------------

import be.ifosup.categorie.Categorie;
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
            request.getRequestDispatcher("vues/ajoutMagasin.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ----------------------- getParameters ---------------------------
        String nom = request.getParameter("magasin");
        nom = nom.trim();

        // ------------------------add to the db ---------------------------

        try {
            if(nom != "" && !nom.contains("<")&& (!nom.isEmpty()))
            {
                magasinDAO.ajouter( new Magasin(nom) );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        try {
            request.setAttribute("magasins", magasinDAO.listMag());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // ---------------------- redirection -----------------------------------------

        request.getRequestDispatcher("vues/magasins.jsp").forward(request, response);
    }
}
