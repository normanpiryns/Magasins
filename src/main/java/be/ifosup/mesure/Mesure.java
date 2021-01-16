package be.ifosup.mesure;

public class Mesure {
    private int id;
    private String mesure;

    public int getId() {
        return id;
    }

    public String getmesure() {
        return mesure;
    }

    public void setmesure(String mesure) {
        this.mesure = mesure;
    }

    public Mesure(int id, String mesure){
        this.id = id;
        this.mesure = mesure;
    }


}
