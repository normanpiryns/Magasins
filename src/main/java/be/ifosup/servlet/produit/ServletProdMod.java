package be.ifosup.servlet.produit;

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

@WebServlet(name = "ServletProdMod", value = "/prodmod")
public class ServletProdMod extends HttpServlet {

    private ProduitDAO produitDAO;
    private MesureDAO mesureDAO;
    private CategorieDAO categorieDAO;
    private MagasinDAO magasinDAO;

    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.produitDAO = daoFactory.getProduitDAO();
        this.categorieDAO = daoFactory.getCategorieDao();
        this.mesureDAO = daoFactory.getMesureDAO();
        this.magasinDAO = daoFactory.getMagasinDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));

        //recupere le produit que l'on veux modifier
        try {
            Produit p = produitDAO.GetProduitByID(id);
            Categorie categorie = categorieDAO.getCategorieByName(p.getCategorie());
            Mesure mesure = mesureDAO.getMesurebyName(p.getMesure());

            Integer fk_cat = categorie.getId();
            Integer fk_mesure =  mesure.getId();

            request.setAttribute("name", p.getNom());
            request.setAttribute("categorie", fk_cat);
            request.setAttribute("mesure", fk_mesure);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("vues/modifierProduit.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer fk_cat = Integer.parseInt(request.getParameter("cat"));
        Integer fk_mesure = Integer.parseInt(request.getParameter("mesure"));
        Integer fk_magasin = Integer.parseInt(request.getParameter("magasin"));
        Double quantite= Double.parseDouble(request.getParameter("quantite"));
        String nom = request.getParameter("nom");

        try {
            Categorie categorie = categorieDAO.getCategorieById(fk_cat);
            Mesure mesure = mesureDAO.getMesurebyID(fk_mesure);
            Magasin magasin = magasinDAO.getMagasinById(fk_magasin);
            // ------------------------add to the db ---------------------------

            produitDAO.Modifier(new Produit(magasin.getNom(), nom, categorie.getNom(), mesure.getNom() ,quantite));
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            request.setAttribute("produits", produitDAO.ListeProduit());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("vues/liste.jsp").forward(request,response);
    }
    }
