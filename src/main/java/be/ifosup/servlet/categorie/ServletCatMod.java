package be.ifosup.servlet.categorie;

import be.ifosup.categorie.Categorie;
import be.ifosup.categorie.CategorieDAO;
import be.ifosup.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletCatMod" , urlPatterns = {"/catmod"})
public class ServletCatMod extends HttpServlet {
    private CategorieDAO categorieDAO;

    public void init() throws ServletException{
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.categorieDAO = daoFactory.getCategorieDao();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //forcer l'utf-8 dans le transfert d'information
        request.setCharacterEncoding("UTF-8");

        //recuperation des champs
        String categorie = request.getParameter("categorie");
        String id = request.getParameter("id");

        //ajouter dans la db
        try {
            categorieDAO.modifier( new Categorie(Integer.parseInt(id),categorie));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //redirection
        try {
            request.setAttribute("categories", categorieDAO.liste());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("vues/categories.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recupération de l'id
        String id = request.getParameter("id");

        try {
            request.setAttribute("categorie", categorieDAO.getCategorieById(Integer.parseInt(id)));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("vues/modifierCategorie.jsp").forward(request,response);
        /*      Ici il faut récuperer par id. Pas besoin de toute la liste. -Norman
        try {
            request.setAttribute("categories", categorieDAO.liste());
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        */
    }
}
