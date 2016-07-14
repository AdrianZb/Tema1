/**
 * Created by azburatura on 7/14/2016.
 */
public class Exercise8 {

    public static void main(String[] agrs){

        //you can't continue the program if you get an error!!!, it can't be caught!!!

        aruncaOutOfMemoryError(20000000);

        aruncaStackOverflowErrorr(2, 3, 4, 2, 3, 4, 5);

    }

    public static void aruncaOutOfMemoryError(int x){
        if(x > 2000000000){
            throw new OutOfMemoryError("x este prea mare, nu e destula memorie!!!!!!");
        }
        System.out.println("Am ajuns cu bine pana aici :)");
    }

    public static void aruncaStackOverflowErrorr(int ... x){
        if(x.length > 5){
            throw new StackOverflowError("prea multa variabile pe stack, system failing....");
        }
        System.out.println("Am ajuns cu bine pana aici :)");
    }

}
