package pizza;

/**
 * Created by azburatura on 7/22/2016.
 */
public class HamAnMushroomPizza extends Pizza {
    @Override
    public void generatePizza() {
        pret = 30;
        diametru = 20;
    }

    @Override
    public String toString() {
        return "HamAnMushroomPizza{pret = " + getPret() + " diametru = " + getDiametru() + "}";
    }
}
