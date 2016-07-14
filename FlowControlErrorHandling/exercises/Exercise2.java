/**
 * Created by azburatura on 7/14/2016.
 */
public class Exercise2 {

    public static void main(String[] args) {
        boolean inTrouble = parrotTrouble(true, 3);
        boolean notInTrouble = parrotTrouble(true, 8);
        boolean notInTrouble2 = parrotTrouble(false, 9);
        System.out.println("In trouble ==> " + inTrouble);
        System.out.println("Not in trouble ==> " + notInTrouble);
        System.out.println("Not in trouble2 ==> " + notInTrouble2);
    }

    public static boolean parrotTrouble(boolean talking, int hour) {
        if (hour < 7 || hour > 20 && talking == true) {
            return true;
        }
        return false;
    }

}
