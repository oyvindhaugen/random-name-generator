package com.oyvindh;

import java.io.*;
import java.util.ArrayList;

public class ReadFile {
    ArrayList<String> listOfLines = new ArrayList();

    void readFileToList() {
        try {
            listOfLines.clear();
            File f = new File("Test.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = br.readLine();
            while (line != null) {
                listOfLines.add(line);
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
