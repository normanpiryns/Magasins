package be.ifosup.categorie;

import java.sql.SQLException;
import java.util.List;

public interface CategorieDAO {
    void ajouter( Categorie categorie) throws SQLException;

    void supprimer( int id) throws SQLException;

    void modifier(Categorie categorie) throws SQLException;

    List<Categorie> liste() throws SQLException;

    public Categorie getCategorieById(int id) throws SQLException;

    public Categorie getCategorieByName(String name) throws SQLException;

    public boolean testCatLink(int id) throws SQLException;
}
