package be.ifosup.servlet;

import be.ifosup.dao.DAOFactory;
import be.ifosup.produit.Produit;
import be.ifosup.produit.ProduitDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletProd", urlPatterns = {"/produit"})
public class ServletProd extends HttpServlet {

    // -------------------------------------------- attributes -------------------------------------------

    private ProduitDAO produitDAO;

    // -------------------------------------------- init method --------------------------------------------------------

    public void init() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.produitDAO = daoFactory.getProduitDAO();
    }

    // ---------------------------------------- doGet ----------------------------------------------------

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/prodAdd.jsp").forward(request, response);
    }

    // ---------------------------------------- doPost ----------------------------------------------------

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        request.setCharacterEncoding("UTF-8");
        String magasin = request.getParameter("");
        String nom = request.getParameter("mag");
        String categorie = request.getParameter("");
        String mesure = request.getParameter("");
        try {
            produitDAO.Ajouter(new Produit(magasin, nom, categorie, mesure));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // -------------------------redirection ----------------------------

        try {
            request.setAttribute("mag", produitDAO.ListeProduit());
            request.getRequestDispatcher("views/produit.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("views/produit.jsp").forward(request, response);
    }

}
