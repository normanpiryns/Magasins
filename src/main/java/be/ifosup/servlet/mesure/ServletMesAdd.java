package be.ifosup.servlet.mesure;

import be.ifosup.categorie.Categorie;
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

@WebServlet(name = "ServletMesAdd", urlPatterns = {"/mesadd"})
public class ServletMesAdd extends HttpServlet {
    private MesureDAO mesureDAO;

    public void init() throws ServletException{
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.mesureDAO =daoFactory.getMesureDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recuperation des champs
        String mesure = request.getParameter("mesure");


        //ajouter dans la db
        try {
            mesureDAO.ajouter( new Mesure(mesure));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //recuperation de la liste des mesures
        try {
            request.setAttribute("mesures", mesureDAO.ListeMesure());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //redirection vers la liste des mesures
        request.getRequestDispatcher("vues/mesures.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("vues/ajoutMesures.jsp").forward(request,response);
    }
}
