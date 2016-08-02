package shape.impl;

import shape.Shape2D;

/**
 * Created by azburatura on 7/8/2016.
 */
public class Square implements Shape2D{

    private int latura;


    @Override
    public double computeArea() {
         return latura * latura;
    }

    @Override
    public double computePerimeter() {
        return  latura * 4;
    }
}
