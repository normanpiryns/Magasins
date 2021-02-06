package be.ifosup.magasin;

import be.ifosup.categorie.Categorie;

import java.sql.SQLException;
import java.util.List;

public interface MagasinDAO {

    // --------------------------------------  list --------------------------------------------------------------------

    List<Magasin> listMag() throws SQLException;

    // ------------------------------------ void methods ---------------------------------------------------------------

    void ajouter (Magasin magasin) throws SQLException;
    void supprimer (int ID_Magasin ) throws SQLException;
    void modifier (Magasin magasin) throws SQLException;
    Magasin getMagasinById(int id ) throws SQLException;
    Magasin getMagasinByName(String name) throws SQLException;


}
