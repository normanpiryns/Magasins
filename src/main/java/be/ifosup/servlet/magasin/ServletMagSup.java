package be.ifosup.servlet.magasin;

import be.ifosup.dao.DAOFactory;
import be.ifosup.magasin.MagasinDAO;
import be.ifosup.produit.Produit;
import be.ifosup.produit.ProduitDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletMagSup", urlPatterns = {"/magsup"})
public class ServletMagSup extends HttpServlet {

    private MagasinDAO magasinDAO;
    private ProduitDAO produitDAO;

    public void init() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.magasinDAO = daoFactory.getMagasinDAO();
        this.produitDAO = daoFactory.getProduitDAO();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // -------------------------------- getParameter ---------------------

        Integer id = Integer.parseInt(request.getParameter("id"));

        // ----------------------------- supression du magasin ------------------
        try {
            List<Produit> test = produitDAO.ListeProduitsByMagId(id);
            if (test.size()>0){
                request.setAttribute("erreur", "magasin non vide");
            }else{
                magasinDAO.supprimer(id);}

        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        // ----------------------------- liste des magasins ------------------
        try{
            request.setAttribute("magasins", magasinDAO.listMag());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // -------------------------------- redirection -----------------------

        request.getRequestDispatcher("vues/magasins.jsp").forward(request, response);
    }
}
