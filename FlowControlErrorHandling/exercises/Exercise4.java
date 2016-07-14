/**
 * Created by azburatura on 7/14/2016.
 */
public class Exercise4 {

    public static void main(String[] args) {
        System.out.println(backAround("cat"));
        System.out.println(backAround("Hello"));
        System.out.println(backAround("a"));
    }

    public static String backAround(String str) {
        char c = str.charAt(str.length() - 1);
        String newStr = c + str + c;
        return newStr;
    }

}
