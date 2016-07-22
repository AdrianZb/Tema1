package visitor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by azburatura on 7/22/2016.
 */
public class VisitorDemo {

    public static void main(String[] args) {

        Document document = new Document();
        String content = readFromFile();
        document.setContent(content);
        Visitor charVisitor = new DocumentCharVisitor();
        Visitor wordsVisitor = new DocumentWordsVisitor();

        System.out.println(charVisitor.visit(document));
        System.out.println(wordsVisitor.visit(document));

    }

    public static String readFromFile() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("D:/exercise/patterns.txt"))) {
            String data;
            while ((data = br.readLine()) != null) {
                sb.append(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


}
