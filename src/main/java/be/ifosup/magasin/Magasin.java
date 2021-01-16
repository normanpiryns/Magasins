package be.ifosup.magasin;

public class Magasin {

    // ---------------------------------------- attributes -------------------------------------------------------------

    private int ID;
    private String Nom;

    // ---------------------------------------- constructors -----------------------------------------------------------

    public Magasin(int ID,String Nom){
        this.ID =ID;
        this.Nom=Nom;
    }

    public Magasin(String Nom){ this.Nom=Nom;}


    // --------------------------------------- getter&setter -----------------------------------------------------------

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
       this.Nom = Nom;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
