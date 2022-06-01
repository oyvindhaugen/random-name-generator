package com.oyvindh;

import java.io.FileWriter;
import java.io.IOException;

public class writeFile {
    private void writeFile(){
        try {
            FileWriter fw = new FileWriter("C:/Java/Test.txt");
            fw.write("Hello");
            fw.close();
            System.out.println("Wrote to file");
        } catch(IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new writeFile().writeFile();
    }
}
