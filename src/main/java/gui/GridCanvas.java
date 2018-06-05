package gui;

import Logic.Ant;
import Logic.Cell;
import Logic.Grid;
import Logic.PlantEatingAnt;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Stream;

public class GridCanvas extends JPanel {
    private int gridWidthx;
    private int gridHeightx;

    JLabel labelOfDeadPlants = new JLabel("Zjedzone roślinożerne:");
    JLabel labelOfDeadMeat = new JLabel("Martwe mięsożerne:");
    JLabel numberOfDeadPlants = new JLabel("0");
    JLabel numberOfDeadMeat = new JLabel("0");

    JLabel labelOfLivePlants = new JLabel("Żyjące roślinożerne:");
    JLabel labelOfLiveMeat = new JLabel("Żyjące mięsożerne:");
    JLabel numberOfLivePlants = new JLabel("0");
    JLabel numberOfLiveMeat = new JLabel("0");

    JLabel labelOfBornPlants = new JLabel("Narodzone roślinożerne:");
    JLabel labelOfBornMeat = new JLabel("Narodzone mięsożerne:");
    JLabel numberOfBornPlants = new JLabel("0");
    JLabel numberOfBornMeat = new JLabel("0");

    Grid grid;

    public GridCanvas(int plantAnts, int meatAnts, int gridHeight, int gridWidth) {
        gridHeightx = gridHeight;
        gridWidthx = gridWidth;
        grid = new Grid(gridWidth,gridHeight,meatAnts,plantAnts);
        setLayout(null);
        setVisible(true);
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                GridCanvas.super.updateUI();
            }
        };
        //running timer task as daemon thread
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 1000, 1000);
        labelOfDeadPlants.setBounds(5,5,135,15);
        labelOfDeadMeat.setBounds(5,20,135,15);
        numberOfDeadPlants.setBounds(145,5,50,15);
        numberOfDeadMeat.setBounds(145,20,50,15);
        labelOfLivePlants.setBounds(5,35,135,15);
        labelOfLiveMeat.setBounds(5,50,135,15);
        numberOfLivePlants.setBounds(145,35,50,15);
        numberOfLiveMeat.setBounds(145,50,50,15);
        labelOfBornPlants.setBounds(5,65,135,15);
        labelOfBornMeat.setBounds(5,80,135,15);
        numberOfBornPlants.setBounds(145,65,50,15);
        numberOfBornMeat.setBounds(145,80,50,15);
        add(numberOfDeadPlants);
        add(numberOfDeadMeat);
        add(labelOfDeadMeat);
        add(labelOfDeadPlants);
        add(numberOfLivePlants);
        add(numberOfLiveMeat);
        add(labelOfLiveMeat);
        add(labelOfLivePlants);
        add(numberOfBornPlants);
        add(numberOfBornMeat);
        add(labelOfBornMeat);
        add(labelOfBornPlants);

        numberOfDeadMeat.setText(Integer.toString(grid.getNumberOfDeadMeat()));
        numberOfDeadPlants.setText(Integer.toString(grid.getNumberOfDeadPlants()));
        numberOfLiveMeat.setText(Integer.toString(grid.getNumberOfMeatEatingAnts()));
        numberOfLivePlants.setText(Integer.toString(grid.getNumberOfPlantEatingAnts()));
        numberOfBornMeat.setText(Integer.toString(grid.getNumberOfBornMeat()));
        numberOfBornPlants.setText(Integer.toString(grid.getNumberOfDeadPlants()));
    }

    @Override
    public String toString() {
        return "GridCanvas{" +
                "gridWidth=" + gridWidthx +
                ", gridHeight=" + gridHeightx +
                '}';
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        final int size = 8;
        final int leftMargin = 200;
        int x=0, y=0;
        Cell[][] cells = grid.getCells();
        Stream<Ant> ants = grid.getAnts().stream();
        g.setColor(Color.black);
        for(x=0;x < gridWidthx; x++){
            for(y=0;y < gridHeightx; y++){
                if(cells[x][y].isWall())
                    g.fillRect(x*size+leftMargin,y*size,size,size);
                else
                    g.drawRect(x*size+leftMargin,y*size,size-1,size-1);
            }

        }
        ants.forEach(a ->{
            if(a instanceof PlantEatingAnt){
                g.setColor(Color.green);
                g.fillRect(a.getX()*size+leftMargin, a.getY()*size,size,size);
            }
            else
            {
                g.setColor(Color.red);
                g.fillRect(a.getX()*size+leftMargin, a.getY()*size,size,size);
            }
        });
        grid.nextTick();

        numberOfDeadMeat.setText(Integer.toString(grid.getNumberOfDeadMeat()));
        numberOfDeadPlants.setText(Integer.toString(grid.getNumberOfDeadPlants()));
        numberOfLiveMeat.setText(Integer.toString(grid.getNumberOfMeatEatingAnts()));
        numberOfLivePlants.setText(Integer.toString(grid.getNumberOfPlantEatingAnts()));
        numberOfBornMeat.setText(Integer.toString(grid.getNumberOfBornMeat()));
        numberOfBornPlants.setText(Integer.toString(grid.getNumberOfDeadPlants()));
    }

    public int getGridWidthx() {
        return gridWidthx;
    }

    public void setGridWidthx(int gridWidthx) {
        this.gridWidthx = gridWidthx;
    }

    public int getGridHeightx() {
        return gridHeightx;
    }

    public void setGridHeightx(int gridHeightx) {
        this.gridHeightx = gridHeightx;
    }

}
