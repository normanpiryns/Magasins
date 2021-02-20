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
import java.util.List;

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
            Mesure mesure = mesureDAO.getMesureByName(p.getMesure());
            List<Categorie> catList = categorieDAO.liste();
            List<Mesure> mesList = mesureDAO.ListeMesure();

            Integer fk_cat = categorie.getId();
            Integer fk_mesure =  mesure.getId();
            //System.out.println(p.getId());
            request.setAttribute("produit" , p);
            request.setAttribute("listCategorie" , catList);
            request.setAttribute("mesureList", mesList);

            request.setAttribute("fkCategorie", fk_cat);
            request.setAttribute("fkMesure", fk_mesure);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("vues/modifierProduit.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer fk_cat = Integer.parseInt(request.getParameter("categorie"));
        Integer fk_mesure = Integer.parseInt(request.getParameter("mesure"));
        Double quantite= Double.parseDouble(request.getParameter("quantite"));
        String nom = request.getParameter("nom");
        String nomMagasin = request.getParameter("magasin");
        try {
            Categorie categorie = categorieDAO.getCategorieById(fk_cat);
            Mesure mesure = mesureDAO.getMesurebyID(fk_mesure);
            Magasin magasin = magasinDAO.getMagasinByName(nomMagasin);

            Produit prodtest =new Produit(id,nomMagasin, nom, categorie.getNom(), mesure.getNom() ,quantite);
            produitDAO.Modifier(prodtest);
            System.out.println(prodtest.getNom() + prodtest.getCategorie() + prodtest.getMesure() + prodtest.getId());

            //produitDAO.Modifier(new Produit(id,nomMagasin, nom, categorie.getNom(), mesure.getNom() , quantite));

            //produitDAO.Modifier(new Produit(1,"lidle", "pomme", "fruit", "piece" , 1.0));




            request.setAttribute("produits",produitDAO.ListeProduitsByMagId(magasin.getID()));
            request.setAttribute("mag_name",nomMagasin);
            request.setAttribute("fk_magasin",magasin.getID());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("vues/liste.jsp").forward(request, response);
    }
    }
