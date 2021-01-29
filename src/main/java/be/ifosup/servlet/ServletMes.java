package be.ifosup.servlet;

import be.ifosup.dao.DAOFactory;
import be.ifosup.mesure.MesureDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletMes",urlPatterns = {"/mes"})
public class ServletMes extends HttpServlet {
    private MesureDAO mesureDAO;

    public void init() throws ServletException{
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.mesureDAO =daoFactory.getMesureDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //redirection
        try {
            request.setAttribute("mesure",mesureDAO.ListeMesure());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("vues/mesures.jsp").forward(request,response);
    }
}
