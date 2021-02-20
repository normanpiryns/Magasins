package be.ifosup.servlet;

import be.ifosup.dao.DAOFactory;
import be.ifosup.magasin.MagasinDAO;
import be.ifosup.mesure.MesureDAO;
import be.ifosup.produit.Produit;
import be.ifosup.produit.ProduitDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletListe", urlPatterns = {"/delliste"})
public class ServletDelListe extends HttpServlet {


    private ProduitDAO produitDAO;
    private MagasinDAO magasinDAO;



    public void init() throws ServletException{
        DAOFactory daoFactory = DAOFactory.getInstance();

        this.produitDAO = daoFactory.getProduitDAO();
        this.magasinDAO = daoFactory.getMagasinDAO();

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer fk_magasin = Integer.parseInt(request.getParameter("fk_magasin"));
        request.setAttribute("fk_magasin",fk_magasin);


        try {
            List<Produit> produits = produitDAO.ListeProduitsByMagId(fk_magasin);
            for (Produit prod:produits) {
                produitDAO.Supprimer(prod.getId());
            }
            request.setAttribute("magasins",magasinDAO.listMag());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.getRequestDispatcher("vues/accueil.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
