package be.ifosup.produit;

public class Produit {
    private int id;
    private String intitule;


    public Produit(int id, String intitule) {
        this.id = id;
        this.intitule = intitule;
    }

    public Produit(String intitule) {
        this.intitule = intitule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
}