package be.ifosup.magasin;

public class Magasin {

    // ---------------------------------------- attributes -------------------------------------------------------------

    private int ID_Magasin;
    private String Nom_Magasin;

    // ---------------------------------------- constructors -----------------------------------------------------------

    public Magasin(int ID_Magasin,String Nom_Magasin){
        this.ID_Magasin=ID_Magasin;
        this.Nom_Magasin=Nom_Magasin;
    }

    public Magasin(String Nom_Magasin){ this.Nom_Magasin=Nom_Magasin;}


    // --------------------------------------- getter&setter -----------------------------------------------------------

    public String getNom_Magasin() {
        return Nom_Magasin;
    }

    public void setNom_Magasin(String nom_Magasin) {
        Nom_Magasin = nom_Magasin;
    }

    public int getID_Magasin() {
        return ID_Magasin;
    }

    public void setID_Magasin(int ID_Magasin) {
        this.ID_Magasin = ID_Magasin;
    }
}
