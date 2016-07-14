/**
 * Created by azburatura on 7/14/2016.
 */
public class Exercise6 {

    public static void main(String[] args) {

        System.out.println(scoresIncreasing(new int[]{1, 3, 4}));
        System.out.println(scoresIncreasing(new int[]{1, 3, 2}));
        System.out.println(scoresIncreasing(new int[]{1, 1, 4}));
        System.out.println(scoresIncreasing(new int[]{1, 2, 3, 4, 5, 6, 7, 2}));

    }

    public static boolean scoresIncreasing(int[] scores) {
        for (int i = 0; i < scores.length - 1; i++) {
            if (!(scores[i] <= scores[i + 1])) {
                return false;
            }
        }
        return true;
    }


}
