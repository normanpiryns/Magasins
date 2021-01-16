package be.ifosup.unite;

import be.ifosup.dao.DAOFactory;
import be.ifosup.produit.Produit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UniteDAOImpl implements UniteDAO {

    private final DAOFactory daoFactory;

    public UniteDAOImpl(DAOFactory daoFactory) {
        this.daoFactory=daoFactory;
    }

    Connection connection =null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultat = null;

    @Override
    public List<Unite> ListeUnite() throws SQLException {
        List<Unite> ListeUnite = new ArrayList<>();
        connection = daoFactory.getConnection();
        preparedStatement = connection.prepareStatement("select * from unite");

        preparedStatement.executeQuery();
        while(resultat.next()){
            int id = resultat.getInt("ID_Unite");
            String unite = resultat.getString("Libelle_Unite");

            Unite user = new Unite(id,unite);

            ListeUnite.add(user);

        }
        return ListeUnite;
    }

    @Override
    public void ajouter(Unite unite) throws SQLException {
        connection = daoFactory.getConnection();
        preparedStatement = connection.prepareStatement("insert into unite(Libelle_Unite) values(?);");
        preparedStatement.setString(1,unite.getUnite());

        preparedStatement.executeUpdate();
    }

    @Override
    public void supprimer(Unite unite) throws SQLException {
        connection = daoFactory.getConnection();
        preparedStatement = connection.prepareStatement("delete into unite(ID_Unite) values(?);");
        preparedStatement.setInt(1,unite.getId());

        preparedStatement.executeQuery();
    }

    @Override
    public void modifier(Unite unite) throws SQLException {
        connection = daoFactory.getConnection();
        preparedStatement = connection.prepareStatement("update into unite(Libelle_Unite) values(?) where ID_Unite =(?);");
        preparedStatement.setString(1,unite.getUnite());
        preparedStatement.setInt(1,unite.getId());

        preparedStatement.executeUpdate();
    }

    public Unite unite(int id ) throws SQLException {
        connection = daoFactory.getConnection();
        preparedStatement = connection.prepareStatement("select Libelle_Unite from unite where ID_Unite = (?) ;");
        preparedStatement.setInt(1,id);

        preparedStatement.executeQuery();
        return new Unite(id, resultat.getString("Libelle_Unite"));
    }
}
