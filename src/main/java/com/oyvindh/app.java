package com.oyvindh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class app extends JFrame {
    static JFrame frame;
    static JButton generate;
    static JLabel name;
    static JLabel count;
    static JMenu menu;
    static JMenuItem reset;
    private static readFile readFile;

    public static void main(String[] args) {
        {
            readFile = new readFile();
            readFile.readFileToList();
            frame = new JFrame("Random Name Generator");

            JMenuBar mb = new JMenuBar();
            menu = new JMenu("Menu");
            reset = new JMenuItem("Reset");
            menu.add(reset);
            generate = new JButton("Click");
            name = new JLabel();
            count = new JLabel();
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 1));
            panel.add(count);
            panel.add(generate);
            panel.add(name);
            name.setHorizontalAlignment(SwingConstants.CENTER);
            generate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new app().randomLogic();
                }
            });
            reset.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new app().reset();
                }
            });
            mb.add(menu);
            frame.setJMenuBar(mb);
            frame.add(panel);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame.setSize(500, 500);
        }
    }

    private void randomLogic() {
        int amountLeft = readFile.listOfLines.size();
        String amountLeftInt = String.valueOf(amountLeft);
        count.setText(amountLeftInt);
        count.setHorizontalAlignment(SwingConstants.CENTER);

        Random r = new Random();
        if (readFile.listOfLines.size() < 1) {
            JOptionPane.showMessageDialog(null, "The list is empty");
        } else {
            int randomItem = r.nextInt(readFile.listOfLines.size());
            String randomElement = readFile.listOfLines.get(randomItem);
            name.setText(randomElement);
            readFile.listOfLines.remove(randomItem);

        }
    }

    private void reset() {
        try {
            final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
            final File currentJar = new File(app.class.getProtectionDomain().getCodeSource().getLocation().toURI());
            if (!currentJar.getName().endsWith(".jar"))
                return;

            final ArrayList<String> command = new ArrayList<String>();
            command.add(javaBin);
            command.add("-jar");
            command.add(currentJar.getPath());

            final ProcessBuilder builder = new ProcessBuilder(command);
            builder.start();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
