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
        preparedStatement = connection.prepareStatement("select * from mesures");

        preparedStatement.executeQuery();
        while (resultat.next()) {
            int id = resultat.getInt("ID_mesure");
            String mesure = resultat.getString("nom_mesure");

            Mesure user = new Mesure(id, mesure);

            listeMesure.add(user);

        }
        return listeMesure;
    }


    @Override
    public void ajouter(Mesure mesure) throws SQLException {
        connection = daoFactory.getConnection();
        preparedStatement = connection.prepareStatement("insert into mesures(nom_mesure) values(?);");
        preparedStatement.setString(1, mesure.getmesure());

        preparedStatement.executeUpdate();
    }

    @Override
    public void supprimer(int id) throws SQLException {
        connection = daoFactory.getConnection();
        preparedStatement = connection.prepareStatement("delete into mesures(ID_mesure) values(?);");
        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();
    }

    @Override
    public void modifier(Mesure mesure) throws SQLException {
        connection = daoFactory.getConnection();
        preparedStatement = connection.prepareStatement("update into mesures(nom_mesure) values(?) where ID_mesure =(?);");
        preparedStatement.setString(1, mesure.getmesure());
        preparedStatement.setInt(1, mesure.getId());

        preparedStatement.executeUpdate();
    }

    @Override
    public Mesure getMesurebyID(int id ) throws SQLException {
        connection = daoFactory.getConnection();
        preparedStatement = connection.prepareStatement("select nom_mesure from mesures where ID_mesure = (?) ;");
        preparedStatement.setInt(1,id);

        preparedStatement.executeQuery();
        return new Mesure(id, resultat.getString("nom_mesure"));
    }
}
