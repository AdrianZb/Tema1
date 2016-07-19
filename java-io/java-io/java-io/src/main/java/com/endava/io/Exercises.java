package com.endava.io;

import java.io.*;

/**
 * Created by azburatura on 7/19/2016.
 */
public class Exercises {

    public static void main(String[] args) {
        String folderName = "D:/exercise/";
        String fileName = folderName + "/myFile.txt";
        String fileName2 = folderName + "/myFile2.txt";
        createFolder(folderName);
        createFile(fileName);
        createFile(fileName2);
        writeToFile(fileName);
        //exercise 1
        countNumberOfA(fileName);
        //exercise 2
        readAndWriteReverse(fileName, fileName2);
        //exercise 3
        writeFolderDetails(folderName, folderName, "");
    }

    public static void createFolder(String folderName) {
        File dir = new File(folderName);
        if (!dir.exists()) {
            try {
                boolean result = dir.mkdir();
                if (result) {
                    System.out.println("DIR created!");
                }
            } catch (SecurityException se) {
                se.printStackTrace();
            }
        } else {
            System.out.println("Directory already exists...");
        }
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
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write("Hello world! \nTest this example.");
            fileWriter.flush();
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    public static void countNumberOfA(String fileName) {
        int count = 0;
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(fileName, "r");
            randomAccessFile.seek(3L);
            int data;
            while ((data = randomAccessFile.read()) != -1) {
                char dataChar = (char) data;
                if (dataChar == 'a' || dataChar == 'A') {
                    count++;
                }
                System.out.print(dataChar);
            }
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } finally {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println();
        System.out.println("\"a\" was found " + count + " times.");
    }

    public static void readAndWriteReverse(String fileNameRead, String fileNameWrite) {
        StringBuilder sb = new StringBuilder();
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(fileNameRead, "r");
            int data;
            while ((data = randomAccessFile.read()) != -1) {
                char dataChar = (char) data;
                sb.append(dataChar);
            }
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } finally {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String[] strings = sb.toString().split(" ");
        sb = new StringBuilder();
        for (int i = strings.length - 1; i > -1; i--) {
            sb.append(strings[i] + " ");
        }
        try (FileWriter fileWriter = new FileWriter(fileNameWrite)) {
            fileWriter.write(sb.toString());
            fileWriter.flush();
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    public static void writeFolderDetails(String filePath, String fileName, String space) {
        System.out.println(space + fileName);
        File parent = new File(filePath);
        if (parent.isDirectory()) {
            File[] files = parent.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    writeFolderDetails(file.getPath(), file.getName() + "/", "\t");
                }
                if (!file.getParentFile().toString().equals(filePath)) {
                    writeFolderDetails(filePath + "\\" + file, file.getName(), "\t");
                } else {
                    writeFolderDetails(filePath + "\\" + file, file.getName(), "\t\t");
                }
            }
        }
    }

}
