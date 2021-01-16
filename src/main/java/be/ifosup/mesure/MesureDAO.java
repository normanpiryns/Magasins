package be.ifosup.mesure;

import java.sql.SQLException;
import java.util.List;

public interface MesureDAO {
    List<Mesure> ListeMesure() throws SQLException;

    void ajouter (Mesure mesure) throws SQLException;

    void supprimer (Mesure mesure) throws SQLException;

    void modifier (Mesure mesure) throws SQLException;
}
