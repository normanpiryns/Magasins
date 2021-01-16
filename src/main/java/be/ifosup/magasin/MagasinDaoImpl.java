package be.ifosup.magasin;

import be.ifosup.dao.DAOFactory;
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
        resultat=statement.executeQuery("select ID_Magasin, Nom_Magasin from magasin");

        while(resultat.next()){
            int id = resultat.getInt("ID_Magasin");
            String Nom = resultat.getString("Nom_Magasin");
            magasins.add(new Magasin(id,Nom));


        }
        return magasins;
    };

    @Override
    public void ajouter(Magasin magasin) throws SQLException {
        connection=daoFactory.getConnection();
        preparedStatement=connection.prepareStatement("insert into magasin (Nom_Magasin)value(?) ");
        preparedStatement.setString(1, magasin.getNom());
        preparedStatement.executeUpdate();


    }

    @Override
    public void supprimer(int ID) throws SQLException {
        connection=daoFactory.getConnection();
        preparedStatement=connection.prepareStatement("delete from magasin where ID_Magasin = ?");
        preparedStatement.setInt(1,ID);
        preparedStatement.executeUpdate();

    }

    @Override
    public void modifier(Magasin magasin) throws SQLException {

    }
}
