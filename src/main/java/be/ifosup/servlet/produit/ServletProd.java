package be.ifosup.servlet.produit;

import be.ifosup.dao.DAOFactory;
import be.ifosup.magasin.MagasinDAO;
import be.ifosup.produit.Produit;
import be.ifosup.produit.ProduitDAO;

import javax.security.auth.login.CredentialException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletProd", urlPatterns = {"/prod"})
public class ServletProd extends HttpServlet {

    // -------------------------------------------- attributes -------------------------------------------

    private ProduitDAO produitDAO;
    private MagasinDAO magasinDAO;

    // -------------------------------------------- init method --------------------------------------------------------

    public void init() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.produitDAO = daoFactory.getProduitDAO();
        this.magasinDAO = daoFactory.getMagasinDAO();
    }

    // ---------------------------------------- doGet ----------------------------------------------------

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer fk_magasin = Integer.parseInt(request.getParameter("id"));

        //redirection
        try{

            request.setAttribute("produits",produitDAO.ListeProduitsByMagId(fk_magasin));
            request.setAttribute("mag_name",magasinDAO.getMagasinById(fk_magasin).getNom());
            request.setAttribute("fk_magasin",fk_magasin);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.getRequestDispatcher("vues/liste.jsp").forward(request, response);
    }
}
