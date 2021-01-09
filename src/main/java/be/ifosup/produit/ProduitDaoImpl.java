package be.ifosup.produit;

import be.ifosup.dao.DAOFactory;

import java.sql.*;
import java.util.List;

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
        return null;
    }

    @Override
    public void ajouter(Produit produit) throws SQLException {
    }

    @Override
    public void supprimer(int id) throws SQLException {
    }

    @Override
    public void modifier(Produit produit) throws SQLException {
    }

}
