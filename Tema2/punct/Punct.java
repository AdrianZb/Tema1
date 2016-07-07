/**
 * Created by azburatura on 7/7/2016.
 */
public class Punct {

    private float x;
    private float y;

    public Punct(float x, float y){
        setX(x);
        setY(y);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void changeCoords(float x, float y){
        setX(x);
        setY(y);
    }

    public void afiseaza(){
        System.out.println("(" + x + ", " + y + ")" );
    }

    public static void main(String[] args){
        Punct p = new Punct(23, 30);
        p.afiseaza();

        p.changeCoords(50, 25);
        p.afiseaza();
    }
}
