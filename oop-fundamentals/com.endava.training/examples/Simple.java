package examples;

/**
 * Created by azburatura on 7/8/2016.
 */
public class Simple {

    int i;

    public Simple(int i) {
        i = 5;
    }

}

class ExtendedSimple extends Simple {

    public ExtendedSimple() {
        super(0);
        System.out.println("Hello from constructor with no args");
    }

    public ExtendedSimple(int i) {
        super(i);
        System.out.println("Hello from constructor with 1 args");
    }

    public ExtendedSimple(int one, int two) {
        super(one);
        System.out.println("Hello from constructor with 2 args");
    }

}
