package be.ifosup.categorie;

import be.ifosup.dao.DAOFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategorieDaoImpl implements CategorieDAO {
    private final DAOFactory daoFactory;

    Connection connection =null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultat = null;

    public CategorieDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public List<Categorie> liste() throws SQLException {
        List<Categorie> categories = new ArrayList<>();

        connection = daoFactory.getConnection();
        statement = connection.createStatement();
        resultat = statement.executeQuery("SELECT * FROM categories");

        while(resultat.next()){
            int id = resultat.getInt("id_categorie");
            String nom = resultat.getString("nom_categorie");

            categories.add(new Categorie(id,nom));
        }
        return categories;
    }

    @Override
    public void ajouter(Categorie categorie) throws SQLException {
        connection = daoFactory.getConnection();

        preparedStatement = connection.prepareStatement("INSERT INTO categories (id_categorie,nom_categorie) VALUES (?,?)");


        preparedStatement.setInt(1,categorie.getId());
        preparedStatement.setString(2,categorie.getNom());

        preparedStatement.executeUpdate();
    }

    @Override
    public void supprimer(int id) throws SQLException {
        connection = daoFactory.getConnection();

        preparedStatement = connection.prepareStatement("DELETE FROM categories WHERE id_categorie = ?");

        preparedStatement.setInt(1,id);

        preparedStatement.executeUpdate();
    }

    @Override
    public void modifier(Categorie categorie) throws SQLException {
        connection = daoFactory.getConnection();

        preparedStatement = connection.prepareStatement("UPDATE categories SET nom_categorie = ? WHERE id_categorie = ?; ");

        preparedStatement.setInt(1,categorie.getId());
        preparedStatement.setString(2,categorie.getNom());


        preparedStatement.executeUpdate();
    }

    @Override
    public Categorie getCategorieById(int id) throws SQLException {


        connection = daoFactory.getConnection();
        preparedStatement = connection.prepareStatement("SELECT nom_categorie FROM categories WHERE id_categorie = ?");
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();

        return new Categorie(id,resultat.getString("nom_categorie"));
    }
}
