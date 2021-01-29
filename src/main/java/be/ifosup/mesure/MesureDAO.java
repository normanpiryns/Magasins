package be.ifosup.mesure;

import be.ifosup.produit.Produit;

import java.sql.SQLException;
import java.util.List;

public interface MesureDAO {
    List<Mesure> ListeMesure() throws SQLException;

    void ajouter (Mesure mesure) throws SQLException;

    void supprimer (int id) throws SQLException;

    void modifier (Mesure mesure) throws SQLException;

    public Mesure getMesurebyID(int id ) throws SQLException;

}
