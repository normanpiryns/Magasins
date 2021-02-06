package be.ifosup.magasin;

import be.ifosup.categorie.Categorie;
import be.ifosup.dao.DAOFactory;
import be.ifosup.mesure.Mesure;
import be.ifosup.produit.Produit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MagasinDaoImpl implements MagasinDAO{

    private  final DAOFactory daoFactory;

    Connection connection =null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultat = null;

    public MagasinDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }


    @Override
    public List<Magasin> listMag() throws SQLException {
        List<Magasin> magasins = new ArrayList<>();
        connection = daoFactory.getConnection();
        statement=connection.createStatement();
        resultat=statement.executeQuery("select * from magasins");

        while(resultat.next()){
            int id = resultat.getInt("id_magasin");
            String Nom = resultat.getString("nom_magasin");
            magasins.add(new Magasin(id,Nom));


        }
        return magasins;
    };

    @Override
    public void ajouter(Magasin magasin) throws SQLException {
        connection=daoFactory.getConnection();
        preparedStatement=connection.prepareStatement("insert into magasins (nom_magasin)value(?) ");
        preparedStatement.setString(1, magasin.getNom());
        preparedStatement.executeUpdate();


    }

    @Override
    public void supprimer(int ID) throws SQLException {
        connection=daoFactory.getConnection();
        preparedStatement=connection.prepareStatement("delete from magasins where id_magasin = ?");
        preparedStatement.setInt(1,ID);
        preparedStatement.executeUpdate();

    }

    @Override
    public void modifier(Magasin magasin) throws SQLException {
        connection = daoFactory.getConnection();

        preparedStatement = connection.prepareStatement("UPDATE magasins SET nom_magasin = ? WHERE id_magasin = ?; ");

        preparedStatement.setInt(2, magasin.getID());
        preparedStatement.setString(1, magasin.getNom());


        preparedStatement.executeUpdate();

    }

    @Override
    public Magasin getMagasinById(int id) throws SQLException {
        connection = daoFactory.getConnection();
        preparedStatement = connection.prepareStatement("SELECT nom_magasin FROM magasins WHERE id_magasin = ?");
        preparedStatement.setInt(1,id);
        resultat = preparedStatement.executeQuery();

        Magasin mag =new Magasin(id,"");

        resultat.next();
           String nomMag = resultat.getString("nom_magasin");
           mag.setNom(nomMag);


        return mag;
    }

    @Override
    public Magasin getMagasinByName(String nom) throws SQLException {


        connection = daoFactory.getConnection();
        preparedStatement = connection.prepareStatement("SELECT id_magasin FROM magasins WHERE nom_magasin = ?");
        preparedStatement.setString(1,nom);
        resultat = preparedStatement.executeQuery();

        resultat.next();

        return new Magasin(resultat.getInt("id_magasin"),nom);
    }
}
