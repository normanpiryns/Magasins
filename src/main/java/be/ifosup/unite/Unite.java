package be.ifosup.unite;

public class Unite  {
    private int id;
    private String unite;

    public int getId() {
        return id;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public Unite(int id, String unite){
        this.id = id;
        this.unite = unite;
    }


}
