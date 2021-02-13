package be.ifosup.produit;

import be.ifosup.categorie.Categorie;
import be.ifosup.categorie.CategorieDAO;
import be.ifosup.dao.DAOFactory;
import be.ifosup.magasin.Magasin;
import be.ifosup.magasin.MagasinDAO;
import be.ifosup.mesure.Mesure;
import be.ifosup.mesure.MesureDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProduitDaoImpl implements ProduitDAO{
    private DAOFactory daoFactory = DAOFactory.getInstance();

    private MesureDAO mesureDAO = daoFactory.getMesureDAO();
    private CategorieDAO categorieDAO = daoFactory.getCategorieDao();
    private MagasinDAO magasinDAO = daoFactory.getMagasinDAO();

    Connection connection =null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultat = null;

    public ProduitDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public List<Produit> ListeProduit() throws SQLException {
        List<Produit> produits = new ArrayList<>();

        connection = daoFactory.getConnection();
        statement = connection.createStatement();
        resultat = statement.executeQuery("SELECT * FROM produits");

        return produits;
    }

    @Override
    public Produit GetProduitByID(int id) throws SQLException {

        connection = daoFactory.getConnection();
        statement = connection.createStatement();
        preparedStatement = connection.prepareStatement("SELECT * FROM produits WHERE id_produit = ?");

        preparedStatement.setInt(1,id);

        resultat = preparedStatement.executeQuery();

        resultat.next();

        String nom = resultat.getString("nom_produit");
        int fk_categorie = resultat.getInt("fk_categorie");//cherché les categories via l'objet java
        int fk_mesure = resultat.getInt("fk_mesure");//cherché les mesure via l'objet java
        int fk_magasin = resultat.getInt("fk_magasin");
        double quantite = resultat.getDouble("quantite");
        Mesure mes = mesureDAO.getMesurebyID(fk_mesure);
        Categorie cat = categorieDAO.getCategorieById(fk_categorie);
        Magasin mag = magasinDAO.getMagasinById(fk_magasin);

        return new Produit(mag.getNom(),nom,cat.getNom(),mes.getNom(),quantite);
    }

    @Override
    public void Ajouter(Produit produit) throws SQLException {
        connection = daoFactory.getConnection();

        preparedStatement = connection.prepareStatement("INSERT INTO produits (nom_produit,fk_magasin,fk_categorie,fk_mesure,quantite) VALUES (?,?,?,?,?)");

        Categorie cat = categorieDAO.getCategorieByName(produit.getCategorie());
        Mesure mes = mesureDAO.getMesureByName(produit.getMesure());
        Magasin mag = magasinDAO.getMagasinByName(produit.getMagasin());

        preparedStatement.setString(1,produit.getNom());
        preparedStatement.setInt(2,mag.getID());
        preparedStatement.setInt(3,cat.getId());
        preparedStatement.setInt(4,mes.getId());
        preparedStatement.setDouble(5,produit.getQuantite());

        preparedStatement.executeUpdate();
    }

    @Override
    public void Supprimer(int id) throws SQLException {
        connection = daoFactory.getConnection();

        preparedStatement = connection.prepareStatement("DELETE FROM produits WHERE id_produit = ?");

        preparedStatement.setInt(1,id);

        preparedStatement.executeUpdate();
    }

    @Override
    public void Modifier(Produit produit) throws SQLException {
        connection = daoFactory.getConnection();

        preparedStatement = connection.prepareStatement("UPDATE produits SET nom_produit = ?, fk_categorie = ?  , fk_mesure = ? , quantite = ? WHERE id_produit = ?; ");

        Categorie cat = categorieDAO.getCategorieByName(produit.getCategorie());
        Mesure mes = mesureDAO.getMesureByName(produit.getMesure());

        preparedStatement.setString(1,produit.getNom());
        preparedStatement.setInt(2,cat.getId());
        preparedStatement.setInt(3,mes.getId());
        preparedStatement.setDouble(4,produit.getQuantite());
        preparedStatement.setInt(5,produit.getId());

        preparedStatement.executeUpdate();
    }

    @Override
    public List<Produit> ListeProduitsByMagId(int fk_mag) throws SQLException {
        List<Produit> produits = new ArrayList<>();

        connection = daoFactory.getConnection();
        preparedStatement = connection.prepareStatement("SELECT * FROM produits WHERE fk_magasin = ?");
        preparedStatement.setInt(1,fk_mag);
        resultat = preparedStatement.executeQuery();

        while(resultat.next()){
            int id = resultat.getInt("id_produit");
            String nom = resultat.getString("nom_produit");
            int fk_categorie = resultat.getInt("fk_categorie");
            int fk_mesure = resultat.getInt("fk_mesure");
            double quantite = resultat.getDouble("quantite");
            Mesure mes = mesureDAO.getMesurebyID(fk_mesure);
            Categorie cat = categorieDAO.getCategorieById(fk_categorie);
            Magasin mag = magasinDAO.getMagasinById(fk_mag);

            produits.add(new Produit(id, mag.getNom(), nom,cat.getNom(),mes.getNom(),quantite));

        }
        return produits;
    }

}
