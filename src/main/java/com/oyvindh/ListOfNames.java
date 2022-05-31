package com.oyvindh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfNames {
    void ListOfNames() {
        Scanner s = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        System.out.println("How many names do you wanna add: ");
        String howManyNames = s.nextLine();
        int howManyNamesInt = Integer.parseInt(howManyNames);
        //names.remove(0);
        for (int i = 0; i < howManyNamesInt; i++) {
            System.out.println("Enter new name: ");
            String newName = s.nextLine();
            names.add(newName);
            System.out.println(names);
        }
        System.out.println("This is the complete list: " + names);
        names = new ArrayList<>();
    }
}
