package com.oyvindh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class App extends JFrame {
    static JFrame frame;
    static JButton generate;
    static JLabel name;
    static JLabel count;
    static JMenu menu;
    static JMenuItem reset;
    static JMenuItem pickFile;
    private static ReadFile readFile;
    private static boolean isPicked;
    ArrayList<String> listOfLinesOpened = new ArrayList();
    File selectedFile = new File("");

    public static final App myApplication = new App();

    public static void main(String[] args) {
        {
            readFile = new ReadFile();
            readFile.readFileToList();
            frame = new JFrame("Random Name Generator");

            ImageIcon img = new ImageIcon("C:/Users/oyvin/IdeaProjects/random-name-generator/src/main/java/com/oyvindh/Icon.png");
            JMenuBar mb = new JMenuBar();
            menu = new JMenu("Menu");
            reset = new JMenuItem("Reset");
            pickFile = new JMenuItem("Open file");
            menu.add(reset);
            menu.add(pickFile);
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
                    if (isPicked) {
                        myApplication.randomLogicOpened();
                    } else {
                        myApplication.randomLogic();
                    }
                }
            });
            reset.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    myApplication.reset();
                }
            });
            pickFile.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    myApplication.readFileOpened();
                    isPicked = true;
                }
            });
            frame.setIconImage(img.getImage());
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
        isPicked = false;
        readFile.readFileToList();
        count.setText(""+ readFile.listOfLines.size());
        name.setText("");

        /*
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
*/
    }

    private void readFileOpened() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            try {
                File f = new File(selectedFile.getAbsolutePath());
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line = br.readLine();
                while (line != null) {
                    listOfLinesOpened.add(line);
                    line = br.readLine();
                }
                System.out.println(listOfLinesOpened);
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void randomLogicOpened() {
        int amountLeft = listOfLinesOpened.size();
        String amountLeftInt = String.valueOf(amountLeft);
        count.setText(amountLeftInt);
        count.setHorizontalAlignment(SwingConstants.CENTER);

        Random r = new Random();
        if (listOfLinesOpened.size() < 1) {
            JOptionPane.showMessageDialog(null, "The list is empty");
        } else {
            int randomItem = r.nextInt(listOfLinesOpened.size());
            String randomElement = listOfLinesOpened.get(randomItem);
            name.setText(randomElement);
            listOfLinesOpened.remove(randomItem);

        }
    }
}
