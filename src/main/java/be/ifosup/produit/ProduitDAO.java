package be.ifosup.produit;

import java.sql.SQLException;
import java.util.List;

public interface ProduitDAO {
    List<Produit> ListeProduit() throws SQLException;

    Produit GetProduitByID(int id) throws SQLException;

    void Ajouter (Produit produit) throws SQLException;

    void Supprimer (int id) throws SQLException;

    void Modifier (Produit produit) throws SQLException;

}
