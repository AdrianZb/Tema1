/**
 * Created by azburatura on 7/14/2016.
 */
public class Exercise5 {

    public static void main(String[] args) {

        System.out.println(everyNth("Miracle", 2));
        System.out.println(everyNth("abcdefg", 2));
        System.out.println(everyNth("abcdefg", 3));
        System.out.println(everyNth("abcdefghijklmno", 2));

    }

    public static String everyNth(String str, int n) {
        StringBuilder stringBuilder = new StringBuilder("" + str.charAt(0));
        for (int i = n; i < str.length(); i += n) {
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }

}
