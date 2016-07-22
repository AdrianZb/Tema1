package pizza;

/**
 * Created by azburatura on 7/22/2016.
 */
public class DeluxePizza extends Pizza{


    @Override
    public void generatePizza() {
        pret = 50;
        diametru = 20;
    }

    @Override
    public String toString() {
        return "DeluxePizza{pret = " + getPret() + " diametru = " + getDiametru() + "}";
    }
}
