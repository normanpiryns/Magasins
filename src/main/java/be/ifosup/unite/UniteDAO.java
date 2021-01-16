package be.ifosup.unite;

import be.ifosup.produit.Produit;

import java.sql.SQLException;
import java.util.List;

public interface UniteDAO {
    List<Unite> ListeUnite() throws SQLException;

    void ajouter (Produit produit) throws SQLException;

    void supprimer (int id) throws SQLException;

    void modifier (Unite unite) throws SQLException;
}
