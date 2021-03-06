package be.ifosup.categorie;

import be.ifosup.dao.DAOFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategorieDaoImpl implements CategorieDAO {
    private final DAOFactory daoFactory;

    Connection connection = null;
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

        while (resultat.next()) {
            int id = resultat.getInt("id_categorie");
            String nom = resultat.getString("nom_categorie");

            categories.add(new Categorie(id, nom));
        }
        return categories;
    }

    @Override
    public void ajouter(Categorie categorie) throws SQLException {
        connection = daoFactory.getConnection();

        preparedStatement = connection.prepareStatement("INSERT INTO categories (nom_categorie) VALUES (?)");

        preparedStatement.setString(1, categorie.getNom());

        preparedStatement.executeUpdate();
    }

    @Override
    public void supprimer(int id) throws SQLException {
        connection = daoFactory.getConnection();

        preparedStatement = connection.prepareStatement("DELETE FROM categories WHERE id_categorie = ?");

        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();
    }

    @Override
    public void modifier(Categorie categorie) throws SQLException {
        connection = daoFactory.getConnection();

        preparedStatement = connection.prepareStatement("UPDATE categories SET nom_categorie = ? WHERE id_categorie = ?; ");

        preparedStatement.setString(1, categorie.getNom());
        preparedStatement.setInt(2, categorie.getId());


        preparedStatement.executeUpdate();
    }

    @Override
    public Categorie getCategorieById(int id) throws SQLException {


        connection = daoFactory.getConnection();
        preparedStatement = connection.prepareStatement("SELECT nom_categorie FROM categories WHERE id_categorie = ?");
        preparedStatement.setInt(1, id);
        resultat = preparedStatement.executeQuery();
        Categorie cat = new Categorie(id, "");

        resultat.next();
        String nomCat = resultat.getString("nom_categorie");
        cat.setNom(nomCat);


        return cat;
    }

    public Categorie getCategorieByName(String nom) throws SQLException {


        connection = daoFactory.getConnection();
        preparedStatement = connection.prepareStatement("SELECT id_categorie FROM categories WHERE nom_categorie = ?");
        preparedStatement.setString(1, nom);
        resultat = preparedStatement.executeQuery();

        resultat.next();

        return new Categorie(resultat.getInt("id_categorie"), nom);
    }

    @Override
    public boolean testCatLink(int id) throws SQLException{
        List<Categorie> categories = new ArrayList<>();

        connection = daoFactory.getConnection();
        preparedStatement = connection.prepareStatement("select * from categories right join produits ON id_categorie = fk_categorie where id_categorie = ?");
        preparedStatement.setInt(1,id);
        resultat = preparedStatement.executeQuery();

        while(resultat.next()){
            String nom = resultat.getString("nom_categorie");

            categories.add(new Categorie(id,nom));
        }

        if (categories.size()>0){
            return false;
        } else {
            return true;
        }
    }
}
