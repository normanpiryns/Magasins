package be.ifosup.servlet.produit;

import be.ifosup.dao.DAOFactory;
import be.ifosup.magasin.MagasinDAO;
import be.ifosup.produit.Produit;
import be.ifosup.produit.ProduitDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletProdSup", urlPatterns = {"/prodsup"})
public class ServletProdSup extends HttpServlet {

    private ProduitDAO produitDAO;
    private MagasinDAO magasinDAO;

    public void init() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.produitDAO = daoFactory.getProduitDAO();
        this.magasinDAO = daoFactory.getMagasinDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // -------------------------------- getParameter ---------------------

        int id = Integer.parseInt(request.getParameter("id"));

        // ----------------------------- Cancel method call ------------------
        try {
            Produit p = produitDAO.GetProduitByID(id);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        // -------------------------------- redirection -----------------------

        request.getRequestDispatcher("views/liste.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
