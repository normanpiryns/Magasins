package be.ifosup.produit;

import be.ifosup.categorie.Categorie;

public class Produit {
    private int id;
    private String nom;
    private String categorie;
    private String mesure;


    public Produit(int id, String nom,String categorie,String mesure) {
        this.id = id;
        this.nom = nom;
        this.categorie = categorie;
        this.mesure = mesure;
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
}