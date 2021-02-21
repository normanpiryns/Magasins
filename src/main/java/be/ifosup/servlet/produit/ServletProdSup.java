package be.ifosup.servlet.produit;

import be.ifosup.dao.DAOFactory;
import be.ifosup.magasin.Magasin;
import be.ifosup.magasin.MagasinDAO;
import be.ifosup.produit.Produit;
import be.ifosup.produit.ProduitDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
        Integer fk_magasin = Integer.parseInt(request.getParameter("fk_magasin"));
        request.setAttribute("fk_magasin",fk_magasin);


        try {
            Magasin magasin = magasinDAO.getMagasinById(fk_magasin);
            produitDAO.Supprimer(id);
            request.setAttribute("produits",produitDAO.ListeProduitsByMagId(fk_magasin));
            request.setAttribute("mag_name",magasin.getNom());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // -------------------------------- redirection -----------------------

        request.getRequestDispatcher("vues/liste.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
