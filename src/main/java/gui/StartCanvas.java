package gui;

import com.sun.corba.se.impl.orbutil.graph.GraphImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


public class StartCanvas extends JPanel {



    private JLabel countOfPlantAntsLabel = new JLabel("Ilość mrówek roślinożernych: ");
    private JLabel countOfMeatAntsLabel = new JLabel("Ilość mrówek mięsożernych: ");
    private JLabel gridHeightLabel = new JLabel("Wysokość siatki: ");
    private JLabel gridWidthLabel = new JLabel("Szerokośc siatki: ");
    private JTextField gridHeight = new JTextField("");
    private JTextField gridWidth = new JTextField("");
    private JTextField countOfPlantAnts = new JTextField("");
    private JTextField countOfMeatAnts = new JTextField("");
    private JButton saveButton = new JButton("Zapisz");

    private int plantsAnts;
    private int meatAnts;
    private int gridHeightValue;
    private int gridWidthValue;


    public StartCanvas() {
        countOfPlantAntsLabel.setBounds(10,10,170,15);
        add(countOfPlantAntsLabel);
        countOfMeatAntsLabel.setBounds(10,30,170,15);
        add(countOfMeatAntsLabel);
        countOfPlantAnts.setBounds(185,8,100,20);
        add(countOfPlantAnts);
        countOfMeatAnts.setBounds(185,28,100,20);
        add(countOfMeatAnts);
        gridHeightLabel.setBounds(10,50,170,15);
        add(gridHeightLabel);
        gridWidthLabel.setBounds(10,70,170,15);
        add(gridWidthLabel);
        gridHeight.setBounds(185,48,100,20);
        add(gridHeight);
        gridWidth.setBounds(185,68,100,20);
        add(gridWidth);
        saveButton.setBounds(185,290,100,30);
        add(saveButton);

        saveButton.addActionListener(e -> {
            plantsAnts = Integer.parseInt(countOfPlantAnts.getText());
            meatAnts = Integer.parseInt(countOfMeatAnts.getText());
            gridHeightValue = Integer.parseInt(gridHeight.getText());
            gridWidthValue = Integer.parseInt(gridWidth.getText());
            GridCanvas gridCanvas = new GridCanvas(plantsAnts,meatAnts,gridHeightValue,gridWidthValue);
            gridCanvas.setPreferredSize(new Dimension((gridWidthValue*8+200), (gridHeightValue*8)));
            JFrame frame = new JFrame ("Grid");
            frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(gridCanvas);
            frame.pack();
            frame.setVisible (true);
            saveButton.setVisible(false);
        });

        setLayout(null);
        setVisible(true);
    }


    public JLabel getCountOfPlantAntsLabel() {
        return countOfPlantAntsLabel;
    }

    public void setCountOfPlantAntsLabel(JLabel countOfPlantAntsLabel) {
        this.countOfPlantAntsLabel = countOfPlantAntsLabel;
    }

    public JLabel getCountOfMeatAntsLabel() {
        return countOfMeatAntsLabel;
    }

    public void setCountOfMeatAntsLabel(JLabel countOfMeatAntsLabel) {
        this.countOfMeatAntsLabel = countOfMeatAntsLabel;
    }

    public JTextField getCountOfPlantAnts() {
        return countOfPlantAnts;
    }

    public void setCountOfPlantAnts(JTextField countOfPlantAnts) {
        this.countOfPlantAnts = countOfPlantAnts;
    }

    public JTextField getCountOfMeatAnts() {
        return countOfMeatAnts;
    }

    public void setCountOfMeatAnts(JTextField countOfMeatAnts) {
        this.countOfMeatAnts = countOfMeatAnts;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }

    public int getPlantsAnts() {
        return plantsAnts;
    }

    public void setPlantsAnts(int plantsAnts) {
        this.plantsAnts = plantsAnts;
    }

    public int getMeatAnts() {
        return meatAnts;
    }

    public void setMeatAnts(int meatAnts) {
        this.meatAnts = meatAnts;
    }

    public JLabel getGridHeightLabel() {
        return gridHeightLabel;
    }

    public void setGridHeightLabel(JLabel gridHeightLabel) {
        this.gridHeightLabel = gridHeightLabel;
    }

    public JLabel getGridWidthLabel() {
        return gridWidthLabel;
    }

    public void setGridWidthLabel(JLabel gridWidthLabel) {
        this.gridWidthLabel = gridWidthLabel;
    }

    public JTextField getGridHeight() {
        return gridHeight;
    }

    public void setGridHeight(JTextField gridHeight) {
        this.gridHeight = gridHeight;
    }

    public JTextField getGridWidth() {
        return gridWidth;
    }

    public void setGridWidth(JTextField gridWidth) {
        this.gridWidth = gridWidth;
    }

    public int getGridHeightValue() {
        return gridHeightValue;
    }

    public void setGridHeightValue(int gridHeightValue) {
        this.gridHeightValue = gridHeightValue;
    }

    public int getGridWidthValue() {
        return gridWidthValue;
    }

    public void setGridWidthValue(int gridWidthValue) {
        this.gridWidthValue = gridWidthValue;
    }
}
