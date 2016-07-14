/**
 * Created by azburatura on 7/14/2016.
 */
public class Exercise10 {

    public static void main(String[] args) {

        int num = executa("123t");
        System.out.println(num);
    }

    public static int executa(String str) {
        try {
            int numar = Integer.valueOf(str);
            return numar;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Se printeaza no matter what...");
        }
        return 0;
    }

}
