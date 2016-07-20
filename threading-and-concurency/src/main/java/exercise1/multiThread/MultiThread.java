package exercise1.multiThread;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by azburatura on 7/20/2016.
 */
public class MultiThread {

    public static void main(String[] args) {

        List<Integer> simpleList = new ArrayList<Integer>();
        List<Integer> primeNumbersList = new ArrayList<Integer>();

        Thread1 thread1 = new Thread1(simpleList);

        Thread2 thread2 = new Thread2(primeNumbersList, thread1);


        long curent = System.currentTimeMillis();
        thread1.start();

        try {
            thread1.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        thread2.start();
        try{
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long after = System.currentTimeMillis();
        System.out.println("A durat: " + (after - curent));

    }


}
