/**
 * Created by azburatura on 7/7/2016.
 */
public class Carte {

    private String titlu;
    private String autor;
    private String editura;
    private int numarPagini;

    public Carte(){}

    public Carte(String titlu, String autor, String editura, int numarPagini){
        setTitlu(titlu);
        setAutor(autor);
        setEditura(editura);
        setNumarPagini(numarPagini);
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditura() {
        return editura;
    }

    public void setEditura(String editura) {
        this.editura = editura;
    }

    public int getNumarPagini() {
        return numarPagini;
    }

    public void setNumarPagini(int numarPagini) {
        this.numarPagini = numarPagini;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "titlu='" + titlu.toUpperCase() + '\'' +
                ", autor='" + autor + '\'' +
                ", editura='" + editura.toLowerCase() + '\'' +
                ", numarPagini=" + numarPagini +
                '}';
    }
}
