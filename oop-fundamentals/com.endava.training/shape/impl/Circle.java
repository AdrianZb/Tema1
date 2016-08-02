package shape.impl;

import shape.Shape2D;
import static java.lang.Math.PI;
/**
 * Created by azburatura on 7/8/2016.
 */
public class Circle implements Shape2D {

    private int r;

    @Override
    public double computeArea() {
        return PI * r * r;
    }

    @Override
    public double computePerimeter() {
        return PI * 2 * r;
    }
}
