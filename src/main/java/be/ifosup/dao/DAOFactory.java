package be.ifosup.dao;

import be.ifosup.categorie.CategorieDAO;
import be.ifosup.categorie.CategorieDaoImpl;
import be.ifosup.mesure.MesureDAO;
import be.ifosup.mesure.MesureDAOImpl;
import be.ifosup.magasin.MagasinDAO;
import be.ifosup.magasin.MagasinDaoImpl;
import be.ifosup.produit.Produit;
import be.ifosup.produit.ProduitDAO;
import be.ifosup.produit.ProduitDaoImpl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {

    //Attributs

    private final String url;
    private final String username;
    private final String password;

    //constructeur

    public DAOFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    //methode qui charge le driver et qui se connecte

    public static be.ifosup.dao.DAOFactory getInstance() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //peu changé selon les systèmes
        be.ifosup.dao.DAOFactory instance = new be.ifosup.dao.DAOFactory("jdbc:mysql://localhost:3306/magasin?serverTimezone=CET", "root", "");
        return instance;
    }

    //methode qui recupere la connection

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public MagasinDAO getMagasinDAO(){ return new MagasinDaoImpl(this);
    }

    public ProduitDAO getProduitDAO(){
        return new ProduitDaoImpl(this);
    }

    public CategorieDAO getCategorieDao(){
        return new CategorieDaoImpl(this);
    }

    public MesureDAO getMesureDAO(){
        return new MesureDAOImpl(this);
    }

}
