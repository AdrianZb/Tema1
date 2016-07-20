package exercise2;

import org.apache.commons.lang.ArrayUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by azburatura on 7/20/2016.
 */
public class Main {

    public static void main(String[] args) {

        String fileName = "D:/exercise/Streams.txt";
        // createFile(fileName);
        // writeToFile(fileName);
        readFromFile(fileName);


    }

    public static void createFile(String fileName) {
        File file = new File(fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("File created!");
            } else {
                System.out.println("File already exists...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write("mere pere portocale banane mere struguri kiwi ananas pere mere pere banane mere");
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    public static void readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {

            String currentLine;
            String text = null;

            while ((currentLine = bufferedReader.readLine()) != null) {
                text = currentLine;
            }

            String[] words = text.split(" ");
            calculeazaProcent(words);
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    public static void calculeazaProcent(String[] words) {
        int count;
        Map<String, Integer> mapa = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            count = 0;
            for (int j = 0; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    count++;
                }
            }
            mapa.put(words[i], count);
        }

        for (Map.Entry entry : mapa.entrySet()) {
            double value = (int) entry.getValue()*100.0 / words.length;
            String stringValue = String.format("%.2f", value);
            System.out.println("Cuvantul " + entry.getKey() + " - > procent: " + stringValue + "%");
        }
    }

    private static String[] removeFromArray(String[] words, String str) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(str)) {
                words = (String[]) ArrayUtils.remove(words, i);
            }
        }
        return words;
    }

}
