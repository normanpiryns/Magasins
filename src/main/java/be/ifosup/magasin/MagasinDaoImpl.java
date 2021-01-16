package be.ifosup.magasin;

import be.ifosup.dao.DAOFactory;
import java.sql.*;
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
        return null;
    }

    @Override
    public void ajouter(Magasin magasin) throws SQLException {

    }

    @Override
    public void supprimer(int ID_Magasin) throws SQLException {

    }

    @Override
    public void modifier(Magasin magasin) throws SQLException {

    }
}
