package gui;

import javax.swing.*;
import java.awt.*;

public class StartCanvas extends JPanel {

    JLabel countOfFloraAnts = new JLabel("Ilość mrówek roślinożernych:");
    JTextField nameField = new JTextField("");
    JTextField surnameField = new JTextField("Imię");
    JPanel inputPanel = new JPanel();


    public StartCanvas() {
        countOfFloraAnts.setBounds(10,10,170,15);
        add(countOfFloraAnts);
        nameField.setBounds(185,8,100,20);
        add(nameField);
        setLayout(null);
        setVisible(true);
    }
}
