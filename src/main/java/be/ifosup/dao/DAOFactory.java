package be.ifosup.dao;

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
        be.ifosup.dao.DAOFactory instance = new be.ifosup.dao.DAOFactory("jdbc:mysql://localhost:3306/poo?serverTimezone=CET", "root", "");
        return instance;
    }

    //methode qui recupere la connection

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public ProduitDAO getProduitDAO(){
        return new ProduitDaoImpl(this);
    }
}
