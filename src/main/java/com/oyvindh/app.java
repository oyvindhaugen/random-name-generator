package com.oyvindh;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class app extends JFrame {
    static JFrame frame;
    static JButton generate;
    static JLabel name;
    static void getRandomNumber(){
        List<String> list = new ArrayList<>();
        list.add(0, "John");
        list.add(1, "Eden");
        list.add(2, "Peter");
        list.add(3, "Ethan");
        Random r = new Random();

        int randomItem = r.nextInt(list.size());
        String randomElement = list.get(randomItem);
        name.setText(randomElement);
        }
    public static void main(String[] args) {
        frame = new JFrame("Random Name Generator");
        generate = new JButton("Click");
        name = new JLabel();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));
        panel.add(generate);
        panel.add(name);
        name.setHorizontalAlignment(SwingConstants.CENTER);
        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getRandomNumber();
            }
        });
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 500);


    }
}
