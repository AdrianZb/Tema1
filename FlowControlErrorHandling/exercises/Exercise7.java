/**
 * Created by azburatura on 7/14/2016.
 */
public class Exercise7 {

    public static void main(String[] args) {

        System.out.println(sumHeights(new int[]{5, 3, 6, 7, 2}, 2, 4));
        System.out.println(sumHeights(new int[]{5, 3, 6, 7, 2}, 0, 1));
        System.out.println(sumHeights(new int[]{5, 3, 6, 7, 2}, 0, 4));

    }

    public static int sumHeights(int[] heights, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += Math.abs(heights[i] - heights[i + 1]);
        }
        return sum;
    }

}
