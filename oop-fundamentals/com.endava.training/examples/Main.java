package examples;

/**
 * Created by azburatura on 7/8/2016.
 */
public class Main {

    public static void main(String[] args) {

        A a = new B();
        a.f();
        ((B) a).f(7, 'r');

        B b = new C();
        b.f();
        b.f(8, 't');
        ((C) b).f("hello friend");

        A a2 = new A();
        a2.f();
        a2.f(7);

    }

}
