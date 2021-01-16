package be.ifosup.categorie;

import java.sql.SQLException;
import java.util.List;

public interface CategorieDAO {
    void ajouter( Categorie categorie) throws SQLException;

    void supprimer( Long id) throws SQLException;

    void modifier(Categorie categorie) throws SQLException;

    List<Categorie> liste() throws SQLException;
}
