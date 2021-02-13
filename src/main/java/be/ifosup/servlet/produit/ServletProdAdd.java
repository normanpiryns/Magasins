package be.ifosup.servlet.produit;

// ----------------------------------------- imports ------------------------------------------------------------------

import be.ifosup.categorie.Categorie;
import be.ifosup.categorie.CategorieDAO;
import be.ifosup.dao.DAOFactory;
import be.ifosup.magasin.Magasin;
import be.ifosup.magasin.MagasinDAO;
import be.ifosup.mesure.Mesure;
import be.ifosup.mesure.MesureDAO;
import be.ifosup.produit.Produit;
import be.ifosup.produit.ProduitDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletProdAdd", urlPatterns = {"/prodadd"})

public class ServletProdAdd extends HttpServlet {

    // ------------------------------------------- Attributes ---------------------------------------------------------

    private ProduitDAO produitDAO;
    private MesureDAO mesureDAO;
    private MagasinDAO magasinDAO;
    private CategorieDAO categorieDAO;


    // -------------------------------------------- init method --------------------------------------------------------

    public void init() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.produitDAO = daoFactory.getProduitDAO();
        this.categorieDAO = daoFactory.getCategorieDao();
        this.magasinDAO = daoFactory.getMagasinDAO();
        this.mesureDAO = daoFactory.getMesureDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idMag = Integer.parseInt(request.getParameter("id_magasin"));
        Integer fk_cat = Integer.parseInt(request.getParameter("categorie"));
        Integer fk_mesure = Integer.parseInt(request.getParameter("mesure"));
        Double quantite= Double.parseDouble(request.getParameter("quantite"));
        String nom = request.getParameter("nom_produit");

        try {
            Categorie categorie =categorieDAO.getCategorieById(fk_cat);
            Mesure mesure =mesureDAO.getMesurebyID(fk_mesure);
            Magasin magasin = magasinDAO.getMagasinById(idMag);
        // ------------------------add to the db ---------------------------

            produitDAO.Ajouter(new Produit(magasin.getNom(), nom, categorie.getNom(), mesure.getNom() ,quantite));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //get de la liste
        try {
            request.setAttribute("produits", produitDAO.ListeProduitsByMagId(idMag));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // ---------------------- redirection -----------------------------------------
        request.getRequestDispatcher("vues/liste.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idMag = Integer.parseInt(request.getParameter("id_magasin"));

        request.setAttribute("id_magasin",idMag);
        try {
            request.setAttribute("categories",categorieDAO.liste());
            request.setAttribute("mesures",mesureDAO.ListeMesure());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("vues/ajoutProduit.jsp").forward(request,response);
    }
}
