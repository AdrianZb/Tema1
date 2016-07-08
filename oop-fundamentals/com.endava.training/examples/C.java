package examples;

/**
 * Created by azburatura on 7/8/2016.
 */
public class C extends B {

    @Override
    public void f() {
        System.out.println("Hello from C");
    }

    public void f(String message){
        System.out.println("Hello from C, this is your message: " + message);
    }

}
