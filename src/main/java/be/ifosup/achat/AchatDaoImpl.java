package be.ifosup.achat;

import be.ifosup.categorie.Categorie;
import be.ifosup.dao.DAOFactory;
import be.ifosup.produit.Produit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AchatDaoImpl implements AchatDAO {
    private final DAOFactory daoFactory;

    Connection connection =null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultat = null;

    public AchatDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
/* //pas besoin immédiatement
    @Override
    public List<Liste> ListeListe() throws SQLException {
        List<Liste> listes = new ArrayList<>();

        connection = daoFactory.getConnection();
        statement = connection.createStatement();
        resultat = statement.executeQuery("SELECT * FROM categories");

        while(resultat.next()){
            int id = resultat.getInt("id_categorie");
            double quantite = resultat.getDouble("quantite");
            int fk_produit = resultat.getInt("fk_produit");
            int fk_magasin = resultat.getInt("fk_magasin");

            listes.add(new Liste(id,quantite,fk_produit,fk_magasin));
        }
        return listes;
    }*/

    @Override
    public void ajouter(Achat achat) throws SQLException {
        connection = daoFactory.getConnection();

        preparedStatement = connection.prepareStatement("INSERT INTO achat (id_achat,quantite_produit,fk_produit,fk_magasin) VALUES (?,?,?,?)");

        preparedStatement.setInt(1,achat.getId());
        preparedStatement.setDouble(1,achat.getQuantite());
        preparedStatement.setInt(2,achat.getFk_produit());
        preparedStatement.setInt(2,achat.getFk_magasin());

        preparedStatement.executeUpdate();
    }

    @Override
    public void supprimer(int id) throws SQLException {
        connection = daoFactory.getConnection();

        preparedStatement = connection.prepareStatement("DELETE FROM achats WHERE id_achat = ?");

        preparedStatement.setLong(1,id);

        preparedStatement.executeUpdate();
    }

    @Override
    public void modifier(Achat achat) throws SQLException {
        connection = daoFactory.getConnection();

        preparedStatement = connection.prepareStatement("UPDATE achats " +
                                                                "SET " +
                                                                    "quantite_produit = ? ," +
                                                                    "fk_produit = ? ,"+
                                                                    "fk_magasin = ? "+
                                                                    "WHERE id_achat = ?; ");

        preparedStatement.setDouble(1,achat.getQuantite());
        preparedStatement.setInt(2,achat.getFk_produit());
        preparedStatement.setInt(2,achat.getFk_magasin());

        preparedStatement.executeUpdate();
    }

    @Override
    public Achat getAchatById(int id) throws SQLException {


        connection = daoFactory.getConnection();
        preparedStatement = connection.prepareStatement("SELECT * FROM achats WHERE id_achat = ?");
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();

        double quantite = resultat.getDouble("quantite");
        int fk_produit = resultat.getInt("fk_produit");
        int fk_magasin = resultat.getInt("fk_magasin");

        return new Achat(id,quantite,fk_produit,fk_magasin);
    }
    @Override
    public List<Achat> getAchatByMagasin(int fk_magasin) throws SQLException {
        List<Achat> achats = new ArrayList<>();

        connection = daoFactory.getConnection();
        preparedStatement = connection.prepareStatement("SELECT * FROM achats WHERE fk_magasin = ?");
        preparedStatement.setInt(1,fk_magasin);
        preparedStatement.executeUpdate();

        while(resultat.next()){
            int id = resultat.getInt("id_categorie");
            double quantite = resultat.getDouble("quantite");
            int fk_produit = resultat.getInt("fk_produit");

            achats.add(new Achat(id,quantite,fk_produit,fk_magasin));
        }
        return achats;
    }
}
