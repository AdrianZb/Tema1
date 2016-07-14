public class Exercise1 {

    public static void main(String[] args) {

        boolean bothTrue = monkeyTrouble(true, true);
        boolean bothFalse = monkeyTrouble(false, false);
        boolean oneTrueOneFalse = monkeyTrouble(true, false);

        System.out.println("Both true returns ==> " + bothTrue);
        System.out.println("Both false returns ==> " + bothFalse);
        System.out.println("One true other false returns ==> " + oneTrueOneFalse);
    }


    public static boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        if (aSmile == true && bSmile == true) {
            return true;
        } else if (aSmile == false && bSmile == false) {
            return true;
        }
        return false;
    }
}
