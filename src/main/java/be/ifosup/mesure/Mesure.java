package be.ifosup.mesure;

public class Mesure {
    private int id;
    private String nom;

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Mesure(int id, String nom){
        this.id = id;
        this.nom = nom;
    }
    public Mesure(String nom){
        this.nom=nom;
    }


}
