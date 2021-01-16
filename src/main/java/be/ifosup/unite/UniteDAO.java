package be.ifosup.unite;

import be.ifosup.produit.Produit;

import java.sql.SQLException;
import java.util.List;

public interface UniteDAO {
    List<Unite> ListeUnite() throws SQLException;

    void ajouter (Unite unite) throws SQLException;

    void supprimer (Unite unite) throws SQLException;

    void modifier (Unite unite) throws SQLException;
}
