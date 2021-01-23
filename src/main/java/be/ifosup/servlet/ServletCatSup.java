package be.ifosup.servlet;

import be.ifosup.categorie.CategorieDAO;
import be.ifosup.dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletCatSup", urlPatterns = {"/catsup"})
public class ServletCatSup extends HttpServlet {
    private CategorieDAO categorieDAO;

    public void init() throws ServletException{
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.categorieDAO =daoFactory.getCategorieDao();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recup de l'id
        int id =Integer.parseInt(request.getParameter("id"));

        //appel methode de suppression
        try {
            categorieDAO.supprimer(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //redirection
        try {
            request.setAttribute("categories",categorieDAO.liste());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("vues/categories.jsp").forward(request,response);

    }
}
