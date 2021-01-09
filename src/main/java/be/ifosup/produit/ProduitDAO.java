package be.ifosup.produit;

import java.sql.SQLException;
import java.util.List;

public interface ProduitDAO {
    List<Produit> ListeProduit() throws SQLException;

    void ajouter (Produit produit) throws SQLException;

    void supprimer (int id) throws SQLException;

    void modifier (Produit produit) throws SQLException;

}
