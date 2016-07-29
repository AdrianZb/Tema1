package model;

/**
 * Created by azburatura on 7/28/2016.
 */
public class User {

    private int id;
    private String nume;
    private String parola;
    private int varsta;

    public User(int id, String nume, String parola, int varsta) {
        this.id = id;
        this.nume = nume;
        this.parola = parola;
        this.varsta = varsta;
    }

    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }
}
