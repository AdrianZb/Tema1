package pizza;

/**
 * Created by azburatura on 7/22/2016.
 */
public abstract class Pizza {

    protected int pret;
    protected int diametru;

    public int getPret() {
        return pret;
    }

    public int getDiametru() {
        return diametru;
    }

    public Pizza(){
        this.generatePizza();
    }

    public abstract void generatePizza();

}
