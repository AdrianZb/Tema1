package pizza;

/**
 * Created by azburatura on 7/22/2016.
 */
public class ProsciutoPizza extends Pizza {
    @Override
    public void generatePizza() {
        pret = 45;
        diametru = 20;
    }

    @Override
    public String toString() {
        return "ProsciutoPizza{pret = " + getPret() + " diametru = " + getDiametru() + "}";
    }
}
