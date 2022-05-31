package com.oyvindh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class app extends JFrame {
    static JFrame frame;
    static JButton generate;
    static JLabel name;

    public static void main(String[] args) {
        {

            frame = new JFrame("Random Name Generator");
            generate = new JButton("Click");
            name = new JLabel();
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(2, 1));
            panel.add(generate);
            panel.add(name);
            name.setHorizontalAlignment(SwingConstants.CENTER);
            System.out.println();
            generate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //System.out.println(names);
//                Random r = new Random();
//
//                int randomItem = r.nextInt(names.size());
//                String randomElement = list.get(randomItem);
//                name.setText(randomElement);
//                list.remove(0);
                }
            });

            frame.add(panel);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setSize(500, 500);


        }
    }}
