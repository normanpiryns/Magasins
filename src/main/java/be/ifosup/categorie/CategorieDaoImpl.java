package be.ifosup.categorie;

import be.ifosup.dao.DAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CategorieDaoImpl {
    private final DAOFactory daoFactory;

    Connection connection =null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultat = null;

    public CategorieDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

}
