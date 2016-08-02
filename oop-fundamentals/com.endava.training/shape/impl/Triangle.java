package shape.impl;

import shape.Shape2D;

/**
 * Created by azburatura on 7/8/2016.
 */
public class Triangle implements Shape2D {

    private int l1;
    private int l2;
    private int l3;
    private int inaltime;

    @Override
    public double computeArea() {
        return (inaltime * (l1 + l2)) / 2;
    }

    @Override
    public double computePerimeter() {
        return l1 + l2 + l3;
    }
}
