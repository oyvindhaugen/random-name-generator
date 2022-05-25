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
    static void getRandomNumber(){
        String[] arr = {"John", "Bobby", "Julian"};
        Random r = new Random();
        int randomNumber = r.nextInt(arr.length);
        name.setText(arr[randomNumber]);}
    public static void main(String[] args) {
        frame = new JFrame("Random Name Generator");
        generate = new JButton("Click");
        name = new JLabel();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,3));
        panel.add(generate);
        panel.add(name);
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
