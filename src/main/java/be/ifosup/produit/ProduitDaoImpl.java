package be.ifosup.produit;

import be.ifosup.categorie.Categorie;
import be.ifosup.categorie.CategorieDAO;
import be.ifosup.dao.DAOFactory;
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
        Mesure mes = mesureDAO.getMesurebyID(fk_mesure);
        Categorie cat = categorieDAO.getCategorieById(fk_categorie);


        Produit produit = new Produit(id,nom,cat.getNom(),mes.getNom());

        return produit;
    }

    @Override
    public void Ajouter(Produit produit) throws SQLException {
        connection = daoFactory.getConnection();

        preparedStatement = connection.prepareStatement("INSERT INTO produits (id_produit,nom_produit,fk_categorie,fk_mesure) VALUES (?,?,?,?)");


        preparedStatement.setInt(1,produit.getId());
        preparedStatement.setString(2,produit.getNom());
        preparedStatement.setString(3,produit.getCategorie());
        preparedStatement.setString(4,produit.getMesure());

        preparedStatement.executeUpdate();
    }

    @Override
    public void Supprimer(int id) throws SQLException {
        connection = daoFactory.getConnection();

        preparedStatement = connection.prepareStatement("DELETE FROM produits WHERE id_produit = ?");

        preparedStatement.setLong(1,id);

        preparedStatement.executeUpdate();
    }

    @Override
    public void Modifier(Produit produit) throws SQLException {
        connection = daoFactory.getConnection();

        preparedStatement = connection.prepareStatement("UPDATE produits SET nom_produit = ?, fk_categorie = ?  , fk_mesure = ? WHERE id_produit = ?; ");

        preparedStatement.setInt(1,produit.getId());
        preparedStatement.setString(2,produit.getNom());
        preparedStatement.setString(3,produit.getCategorie());
        preparedStatement.setString(4,produit.getMesure());

        preparedStatement.executeUpdate();
    }
}
