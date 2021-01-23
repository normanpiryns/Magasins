package be.ifosup.servlet;

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

        String id = request.getParameter("id");

        // ----------------------------- Cancel method call ------------------
        try {
            magasinDAO.supprimer((int) Long.parseLong(id));
            request.setAttribute("mag", magasinDAO.listMag());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // -------------------------------- redirection -----------------------

        request.getRequestDispatcher("views/mag.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
