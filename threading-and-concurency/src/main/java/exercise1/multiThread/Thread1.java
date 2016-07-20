package exercise1.multiThread;

import java.util.List;
import java.util.Random;

/**
 * Created by azburatura on 7/20/2016.
 */
public class Thread1 extends Thread {

    List<Integer> simpleList;

    public Thread1(List<Integer> simpleList) {
        setSimpleList(simpleList);
    }


    public  List<Integer> getSimpleList() {
        return simpleList;
    }

    public void setSimpleList(List<Integer> simpleList) {
        this.simpleList = simpleList;
    }

    public void populateList() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            getSimpleList().add(random.nextInt(100000));
        }
    }

    public void showSimpleList() {
        System.out.println(getSimpleList());
    }

    @Override
    public synchronized void run() {
        populateList();
        showSimpleList();
    }
}
