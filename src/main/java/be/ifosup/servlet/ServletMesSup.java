package be.ifosup.servlet;

import be.ifosup.dao.DAOFactory;
import be.ifosup.mesure.Mesure;
import be.ifosup.mesure.MesureDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletMesSup", urlPatterns = {"/messup"})
public class ServletMesSup extends HttpServlet {

    private MesureDAO mesureDAO;

    public void init() throws ServletException{
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.mesureDAO =daoFactory.getMesureDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));

        //suppression de la mesure
        try {
            mesureDAO.supprimer(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //recuperation de la liste de mesure
        try {
           request.setAttribute("mesures",mesureDAO.ListeMesure());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //redirection vers la liste des mesures
        request.getRequestDispatcher("vues/mesures.jsp").forward(request,response);
    }
}
