package be.ifosup.achat;

import java.sql.SQLException;
import java.util.List;

public interface AchatDAO {
    void ajouter( Achat achat) throws SQLException;

    void supprimer( int id) throws SQLException;

    void modifier(Achat achat) throws SQLException;

    Achat getAchatById(int id) throws SQLException;

    List<Achat> getAchatByMagasin(int fk_magasin) throws SQLException;

}
