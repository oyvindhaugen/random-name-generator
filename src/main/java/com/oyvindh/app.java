package com.oyvindh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class app extends JFrame {
    static JFrame frame;
    static JButton generate;
    static JLabel name;
    private static ListOfNames listOfNames;

    public static void main(String[] args) {
        {
            listOfNames = new ListOfNames();
            listOfNames.ListOfNames();
            frame = new JFrame("Random Name Generator");
            generate = new JButton("Click");
            name = new JLabel();
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(2, 1));
            panel.add(generate);
            panel.add(name);
            name.setHorizontalAlignment(SwingConstants.CENTER);
            generate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(listOfNames.names);
                    Random r = new Random();

                    int randomItem = r.nextInt(listOfNames.names.size());
                    String randomElement = listOfNames.names.get(randomItem);
                    name.setText(randomElement);
                    listOfNames.names.remove(randomItem);
                }
            });

            frame.add(panel);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setSize(500, 500);
        }
    }
}
