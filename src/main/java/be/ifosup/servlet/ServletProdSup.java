package be.ifosup.servlet;

import be.ifosup.dao.DAOFactory;
import be.ifosup.produit.ProduitDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletCategoriesSup", urlPatterns = {"/prodsup"})
public class ServletProdSup extends HttpServlet {

    private ProduitDAO produitDAO;

    public void init() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.produitDAO = daoFactory.getProduitDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // -------------------------------- getParameter ---------------------

        String id = request.getParameter("id");

        // ----------------------------- Cancel method call ------------------
        try {
            produitDAO.Supprimer((int) Long.parseLong(id));
            request.setAttribute("prod", produitDAO.ListeProduit());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // -------------------------------- redirection -----------------------

        request.getRequestDispatcher("views/prod.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
