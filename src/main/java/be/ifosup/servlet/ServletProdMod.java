package be.ifosup.servlet;

import be.ifosup.dao.DAOFactory;
import be.ifosup.produit.Produit;
import be.ifosup.produit.ProduitDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletProdMod", value = "/ServletProdMod")
public class ServletProdMod extends HttpServlet {

    private ProduitDAO produitDAO;

    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.produitDAO = daoFactory.getProduitDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        try {
            request.setAttribute("produit", produitDAO.GetProduitByID(Integer.parseInt(id)));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("vues/modifierProduit.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String produit = request.getParameter("produit");

        try {
            produitDAO.Modifier( new Produit(produit));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            request.setAttribute("produit", produitDAO.ListeProduit());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("vues/ajoutProduit.jsp").forward(request,response);
    }
    }
