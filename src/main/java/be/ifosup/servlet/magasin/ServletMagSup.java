package be.ifosup.servlet.magasin;

import be.ifosup.dao.DAOFactory;
import be.ifosup.magasin.MagasinDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletMagSup", urlPatterns = {"/magsup"})
public class ServletMagSup extends HttpServlet {

    private MagasinDAO magasinDAO;

    public void init() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.magasinDAO = daoFactory.getMagasinDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // -------------------------------- getParameter ---------------------

        Integer id = Integer.parseInt(request.getParameter("id"));

        // ----------------------------- supression du magasin ------------------
        try {
            magasinDAO.supprimer(id);
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        // ----------------------------- liste des magasins ------------------
        try{
            request.setAttribute("mag", magasinDAO.listMag());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // -------------------------------- redirection -----------------------

        request.getRequestDispatcher("vues/magasin.jsp").forward(request, response);
    }
}
