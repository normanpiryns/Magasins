package be.ifosup.servlet;

// ----------------------------------------- imports ------------------------------------------------------------------

import be.ifosup.dao.DAOFactory;
import be.ifosup.produit.Produit;
import be.ifosup.produit.ProduitDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletCategoriesAdd", urlPatterns = {"/prodadd"})

public class ServletProdAdd extends HttpServlet {

    // ------------------------------------------- Attributes ---------------------------------------------------------

    private ProduitDAO produitDAO;


    // -------------------------------------------- init method --------------------------------------------------------

    public void init() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.produitDAO = daoFactory.getProduitDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/prodAdd.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




        // ---------------------- UTF-8 forcing ----------------------------

        request.setCharacterEncoding("UTF-8");

        // ----------------------- getParameters ---------------------------
        String nom = request.getParameter("cprod");
        String categorie = request.getParameter("");
        String mesure = request.getParameter("");


        // ------------------------add to the db ---------------------------

        try {
            produitDAO.Ajouter( new Produit(nom,categorie,mesure) );



        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            request.setAttribute("mag", produitDAO.ListeProduit());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // ---------------------- redirection -----------------------------------------

        request.getRequestDispatcher("views/prodAdd.jsp").forward(request, response);
    }
}
