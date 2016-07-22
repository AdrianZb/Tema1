import java.util.ArrayList;
import java.util.List;

public class LetterMapping {

    private String letter;
    private int number;


    public LetterMapping(String letter, int number) {
        this.number = number;
        this.letter = letter;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getLetter() {
        return letter;
    }


    public void setLetter(String letter) {
        this.letter = letter;

    }

    @Override
    public String toString() {
        return "LetterMapping{" +
                "letter='" + letter + '\'' +
                ", number=" + number +
                '}';
    }

}

class Main {
    public static void main(String[] args) {

        List<LetterMapping> lista = generateLetterMappingAlphabet();
        for (LetterMapping l : lista) {
            System.out.println(l);
        }

    }

    public static List<LetterMapping> generateLetterMappingAlphabet() {
        List<LetterMapping> lista = new ArrayList<LetterMapping>();
        int i = 1;
        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
            LetterMapping letterMapping = new LetterMapping(alphabet + "", i);
            lista.add(letterMapping);
            i++;
        }
        return lista;
    }

}
