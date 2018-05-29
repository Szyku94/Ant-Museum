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
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
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
        int x=0, y=0;
        Cell[][] cells = grid.getCells();
        Stream<Ant> ants = grid.getAnts().stream();
        g.setColor(Color.black);
        for(x=0;x < gridWidthx; x++){
            for(y=0;y < gridHeightx; y++){
                if(cells[x][y].isWall())
                    g.fillRect(x*size,y*size,size,size);
                else
                    g.drawRect(x*size,y*size,size-1,size-1);
            }

        }
        ants.forEach(a ->{
            if(a instanceof PlantEatingAnt){
                g.setColor(Color.green);
                g.fillRect(a.getX()*size, a.getY()*size,size,size);
            }
            else
            {
                g.setColor(Color.red);
                g.fillRect(a.getX()*size, a.getY()*size,size,size);
            }
        });
        grid.nextTick();
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
