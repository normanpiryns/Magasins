package be.ifosup.servlet.mesure;

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

@WebServlet(name = "ServletMesMod", urlPatterns = {"/mesmod"})
public class ServletMesMod extends HttpServlet {

    private MesureDAO mesureDAO;

    public void init() throws ServletException{
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.mesureDAO =daoFactory.getMesureDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //forcer l'utf-8 dans le transfert d'information
        request.setCharacterEncoding("UTF-8");

        //recuperation des champs
        String mesure = request.getParameter("mesure");
        Integer id = Integer.parseInt(request.getParameter("id"));

        //modifier dans dans la db
        try {
            mesureDAO.modifier( new Mesure(id,mesure));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //redirection
        try {
            request.setAttribute("mesures", mesureDAO.ListeMesure());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("vues/mesures.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));

        //recupere la mesure que l'on veux modifier
        try {
            request.setAttribute("mesure",mesureDAO.getMesurebyID(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //redirection vers la page de modification de la mesure
        request.getRequestDispatcher("vues/modifierMesure.jsp").forward(request,response);
    }
}
