package be.ifosup.servlet;

import be.ifosup.dao.DAOFactory;
import be.ifosup.magasin.MagasinDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletMagAdd", urlPatterns = {"/MagAdd"})
public class ServletMagAdd extends HttpServlet {


    private MagasinDAO MagasinDAO;


    public void init() {

        DAOFactory daoFactory = DAOFactory.getInstance();
        this.MagasinDAO = daoFactory.getMagasinDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
