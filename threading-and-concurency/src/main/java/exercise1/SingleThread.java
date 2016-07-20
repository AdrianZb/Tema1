package exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SingleThread {

    public static void main(String[] args) {

        List<Integer> simpleList = new ArrayList<Integer>();
        List<Integer> primeNumbersList = new ArrayList<Integer>();
        long curent = System.currentTimeMillis();
        populateList(simpleList);
        populateListOfPrimeNumbers(simpleList, primeNumbersList);
        System.out.println(simpleList);
        System.out.println(primeNumbersList);
        long after = System.currentTimeMillis();
        System.out.println("A durat: " + (after - curent));


    }

    public static void populateList(List<Integer> list) {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            list.add(random.nextInt(100000));
        }
    }

    public static int nrDivizori(int num) {
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

    public static boolean isPrim(int num) {
        if (nrDivizori(num) == 2) {
            return true;
        }
        return false;
    }

    public static void populateListOfPrimeNumbers(List<Integer> simpleList, List<Integer> primeNumbersList) {
        for (Integer element : simpleList) {
            if (isPrim(element)) {
                primeNumbersList.add(element);
            }
        }
    }
}
