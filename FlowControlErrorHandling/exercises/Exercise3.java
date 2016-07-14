/**
 * Created by azburatura on 7/14/2016.
 */
public class Exercise3 {

    public static void main(String[] args) {

        boolean firstPositiveSecondNegative = posNeg(1, -1, false);
        boolean firstNegativeSecondPositive = posNeg(-1, 1, false);
        boolean bothNegativeConditionTrue = posNeg(-4, -5, true);

        System.out.println(firstPositiveSecondNegative);
        System.out.println(firstNegativeSecondPositive);
        System.out.println(bothNegativeConditionTrue);

    }

    public static boolean posNeg(int a, int b, boolean negative) {
        if (a < 0 && b > 0) {
            return true;
        } else if (a > 0 && b < 0) {
            return true;
        } else if (negative && a < 0 && b < 0) {
            return true;
        }
        return false;
    }

}
