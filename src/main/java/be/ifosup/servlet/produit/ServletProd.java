package be.ifosup.servlet.produit;

import be.ifosup.dao.DAOFactory;
import be.ifosup.produit.Produit;
import be.ifosup.produit.ProduitDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletProd", urlPatterns = {"/prod"})
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
        Integer id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("fk_magasin",request.getParameter("id"));

        //redirection
        try{
            request.setAttribute("produits",produitDAO.ListeProduitsByMagId(id));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.getRequestDispatcher("vues/liste.jsp").forward(request, response);
    }
}
