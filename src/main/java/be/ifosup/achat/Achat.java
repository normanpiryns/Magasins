package be.ifosup.achat;

public class Achat {
    private int id;
    private double quantite;
    private int fk_produit;
    private int fk_magasin;

    public Achat(int id, double quantite , int fk_produit, int fk_magasin) {
        this.id = id;
        this.quantite = quantite;
        this.fk_produit = fk_produit;
        this.fk_magasin = fk_magasin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
    public int getFk_produit(){
        return fk_produit;
    }
    public void setFk_produit(int fk_produit) {
        this.fk_produit = fk_produit;
    }

    public int getFk_magasin() {
        return fk_magasin;
    }

    public void setFk_magasin(int fk_magasin) {
        this.fk_magasin = fk_magasin;
    }
}