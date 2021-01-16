package be.ifosup.produit;

import be.ifosup.dao.DAOFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProduitDaoImpl implements ProduitDAO{
    private final DAOFactory daoFactory;

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
        resultat = statement.executeQuery("SELECT * FROM produit");
        while(resultat.next()){
            int id = resultat.getInt("id_produit");
            String intitule = resultat.getString("nom_produit");
            int fk_categorie = resultat.getInt("fk_categorie");
            int fk_unite = resultat.getInt("fk_unite");

            Produit Produit = new Produit(id,intitule,fk_categorie,fk_unite);
            produits.add(Produit);
        }
        return produits;
    }

    @Override
    public void ajouter(Produit produit) throws SQLException {
        connection = daoFactory.getConnection();

        preparedStatement = connection.prepareStatement("INSERT INTO produit (id_produit,intitule_produit,fk_categorie,fk_unite) VALUES (?,?,?,?)");


        preparedStatement.setInt(1,produit.getId());
        preparedStatement.setString(2,produit.getIntitule());
        preparedStatement.setInt(3,produit.getFk_categorie());
        preparedStatement.setInt(4,produit.getFk_untie());

        preparedStatement.executeUpdate();
    }

    @Override
    public void supprimer(int id) throws SQLException {
        connection = daoFactory.getConnection();

        preparedStatement = connection.prepareStatement("DELETE FROM produit WHERE id_produit = ?");

        preparedStatement.setLong(1,id);

        preparedStatement.executeUpdate();
    }

    @Override
    public void modifier(Produit produit) throws SQLException {
        connection = daoFactory.getConnection();

        preparedStatement = connection.prepareStatement("UPDATE produit SET intitule_produit = ?, fk_categorie = ?  , fk_unite = ? WHERE id_produit = ?; ");

        preparedStatement.setInt(1,produit.getId());
        preparedStatement.setString(2,produit.getIntitule());
        preparedStatement.setInt(3,produit.getFk_categorie());
        preparedStatement.setInt(4,produit.getFk_untie());

        preparedStatement.executeUpdate();
    }

}
