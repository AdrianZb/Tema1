package exercise9;

import java.util.Arrays;
import java.util.List;

/**
 * Created by azburatura on 7/14/2016.
 */
public class Calculator {

    //we will use unchecked exceptions because if we are careful then the exceptions won't ever be thrown
    public Integer add(Integer a, Integer b) {
        if (a + b > Integer.MAX_VALUE) {
            throw new OverflowException("MAX Value exceeded!");
        } else if (a + b < Integer.MIN_VALUE) {
            throw new UnderflowException("Lower than min_value!!");
        }
        return a + b;
    }

    public Integer divide(Integer a, Integer b) {
        return a / b;
    }

    public Integer average(List<Integer> collection) {
        int average = 0;
        for (int i = 0; i < collection.size() - 1; i += 2) {
            average += add(collection.get(i), collection.get(i + 1));
        }
        return divide(average, collection.size());
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
        List<Integer> lista = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6});
        System.out.println(c.average(lista));
    }

}
