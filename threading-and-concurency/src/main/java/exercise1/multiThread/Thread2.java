package exercise1.multiThread;

import java.util.List;

/**
 * Created by azburatura on 7/20/2016.
 */
public class Thread2 extends Thread {

    private List<Integer> primeNumbersList;
    private exercise1.multiThread.Thread1 thread1;

    public Thread2(List<Integer> primeNumbersList, exercise1.multiThread.Thread1 thread1) {
        setPrimeNumbersList(primeNumbersList);
        setThread1(thread1);
    }

    public List<Integer> getPrimeNumbersList() {
        return primeNumbersList;
    }

    public void setPrimeNumbersList(List<Integer> primeNumbersList) {
        this.primeNumbersList = primeNumbersList;
    }

    public exercise1.multiThread.Thread1 getThread1() {
        return thread1;
    }

    public void setThread1(exercise1.multiThread.Thread1 thread1) {
        this.thread1 = thread1;
    }

    public void populatePrimeNumbersList(List<Integer> simpleList) {
        for (Integer element : simpleList) {
            if (isPrim(element)) {
                getPrimeNumbersList().add(element);
            }
        }
    }

    public int nrDivizori(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
            if (count > 2) {
                break;
            }
        }
        return count;
    }

    public boolean isPrim(int num) {
        if (nrDivizori(num) == 2) {
            return true;
        }
        return false;
    }

    public void showPrimeNumbersList() {
        System.out.println(getPrimeNumbersList());
    }

    @Override
    public synchronized void run() {
        populatePrimeNumbersList(getThread1().getSimpleList());
        showPrimeNumbersList();
    }
}
