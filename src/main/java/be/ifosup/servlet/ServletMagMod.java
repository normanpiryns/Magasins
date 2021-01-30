package be.ifosup.servlet;

import be.ifosup.magasin.Magasin;
import be.ifosup.magasin.MagasinDAO;
import be.ifosup.dao.DAOFactory;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletMagMod", value = "/magmod")
public class ServletMagMod extends HttpServlet {

    private MagasinDAO magasinDAO;

    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.magasinDAO = daoFactory.getMagasinDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));

        try {
            request.setAttribute("magasin", magasinDAO.getMagasinById(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("vues/modifierMagasin.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String magasin = request.getParameter("magasin");

        try {
            magasinDAO.modifier( new Magasin(magasin));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            request.setAttribute("magasin", magasinDAO.listMag());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("vues/magasins.jsp").forward(request,response);
    }
}
