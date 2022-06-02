package com.oyvindh;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileChooser extends Component {
    String selectedFile = new String();
    void fileChooser(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        }
    }
}
