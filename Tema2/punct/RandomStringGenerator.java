import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by azburatura on 7/7/2016.
 */
public class RandomStringGenerator {

    private int lungime;
    private String alfabet;

    public RandomStringGenerator(int lungime, String alfabet){
        if(lungime > alfabet.length()){
            lungime = alfabet.length() - 1;
        }
        setLungime(lungime);
        setAlfabet(alfabet);
    }

    public String next(){
        char[] a = getAlfabet().toCharArray();
        amesteca(a);
        String s = new String(a);

        Random generator = new Random();
        int value = getLungime();
        s = s.substring(0, value);
        return s;
    }

    public int getLungime() {
        return lungime;
    }

    public void setLungime(int lungime) {
        this.lungime = lungime;
    }

    public String getAlfabet() {
        return alfabet;
    }

    public void setAlfabet(String alfabet) {
        this.alfabet = alfabet;
    }

    public static void main(String[] args){
        RandomStringGenerator stringGenerator = new RandomStringGenerator(20, "abcdefghijklmno");
        String s = stringGenerator.next();
        System.out.println(s);
    }

    private static void amesteca(char[] c){
        Random rnd = ThreadLocalRandom.current();
        for(int i=0;i<c.length;i++){
            int index = rnd.nextInt(i + 1);

            char a = c[index];
            c[index] = c[i];
            c[i] = a;
        }
    }

}
