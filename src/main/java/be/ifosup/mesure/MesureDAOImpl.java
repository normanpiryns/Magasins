package be.ifosup.mesure;

import be.ifosup.dao.DAOFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MesureDAOImpl implements MesureDAO {

    private final DAOFactory daoFactory;

    public MesureDAOImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    Connection connection = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultat = null;

    @Override
    public List<Mesure> ListeMesure() throws SQLException {
        List<Mesure> listeMesure = new ArrayList<>();
        connection = daoFactory.getConnection();
        statement = connection.createStatement();
        resultat = statement.executeQuery("select * from mesures");
        while (resultat.next()) {
            int id = resultat.getInt("id_mesure");
            String nom = resultat.getString("nom_mesure");

            Mesure user = new Mesure(id, nom);

            listeMesure.add(user);

        }
        return listeMesure;
    }


    @Override
    public void ajouter(Mesure mesure) throws SQLException {
        connection = daoFactory.getConnection();
        preparedStatement = connection.prepareStatement("insert into mesures(nom_mesure) values (?);");
        preparedStatement.setString(1, mesure.getNom());

        preparedStatement.executeUpdate();
    }

    @Override
    public void supprimer(int id) throws SQLException {
        connection = daoFactory.getConnection();
        preparedStatement = connection.prepareStatement("delete from mesures where id_mesure = ?;");
        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();
    }

    @Override
    public void modifier(Mesure mesure) throws SQLException {
        connection = daoFactory.getConnection();
        preparedStatement = connection.prepareStatement("update mesures set nom_mesure = ? where id_mesure = ?;");
        preparedStatement.setString(1, mesure.getNom());
        preparedStatement.setInt(2, mesure.getId());

        preparedStatement.executeUpdate();
    }

    @Override
    public Mesure getMesurebyID(int id ) throws SQLException {
        connection = daoFactory.getConnection();
        preparedStatement = connection.prepareStatement("select nom_mesure from mesures where id_mesure = ? ;");
        preparedStatement.setInt(1,id);
        resultat = preparedStatement.executeQuery();

        String s= "";

        while(resultat.next()){
            s = resultat.getString("nom_mesure");
        }

        return new Mesure(id,s);
    }
}
