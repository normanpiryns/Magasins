package be.ifosup.produit;

import be.ifosup.categorie.Categorie;

public class Produit {
    private int id;
    private String nom;
    private String categorie;
    private String mesure;
    private String magasin;

    private Double quantite;

    public Produit(String magasin, String nom, String categorie, String mesure, Double quantite){
        this.nom = nom;
        this.categorie=categorie;
        this.mesure=mesure;
        this.magasin=magasin;
        this.quantite = quantite;
    }


    public Produit(int id,String magasin, String nom, String categorie, String mesure, Double quantite) {
        this.id = id;
        this.magasin=magasin;
        this.nom = nom;
        this.categorie = categorie;
        this.mesure = mesure;
        this.quantite = quantite;
    }

    public Produit(String nom) {
       this.nom=nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getMesure() {
        return mesure;
    }

    public void setMesure(String mesure) {
        this.mesure = mesure;
    }

    public String getMagasin() {
        return magasin;
    }

    public void setMagasin(String magasin) {
        this.magasin = magasin;
    }

    public Double getQuantite() { return quantite; }

    public void setQuantite(Double quantite) { this.quantite = quantite; }
}
