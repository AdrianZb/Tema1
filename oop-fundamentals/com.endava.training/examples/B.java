package examples;

/**
 * Created by azburatura on 7/8/2016.
 */
public class B extends A {

    @Override
    public void f() {
        System.out.println("Hello from B");
    }


    public void f(int number, char caracter) {
        System.out.println("Hello from B, with 2 args, your number is " + number + " and your caracter is " + caracter);
    }
}
