package be.ifosup.produit;

public class Produit {
    private int id;
    private String intitule;
    private int fk_categorie;
    private int fk_untie;


    public Produit(int id, String intitule,int fk_categorie,int fk_untie) {
        this.id = id;
        this.intitule = intitule;
        this.fk_categorie = fk_categorie;
        this.fk_untie = fk_untie;
    }

    public Produit(String intitule) {
        this.intitule = intitule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getFk_categorie() {
        return fk_categorie;
    }

    public void setFk_categorie(int fk_categorie) {
        this.fk_categorie = fk_categorie;
    }

    public int getFk_untie() {
        return fk_untie;
    }

    public void setFk_untie(int fk_untie) {
        this.fk_untie = fk_untie;
    }

}