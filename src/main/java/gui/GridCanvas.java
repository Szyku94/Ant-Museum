package gui;

import Logic.Cell;
import Logic.Grid;

import javax.swing.*;
import java.awt.*;

public class GridCanvas extends JPanel {
    private int gridWidthx;
    private int gridHeightx;
    private int meatAntsx;
    private int plantAntsx;

    public GridCanvas(int plantAnts, int meatAnts, int gridHeight, int gridWidth) {
        gridWidthx = gridWidth;
        gridHeightx=gridHeight;
        plantAntsx=plantAnts;
        meatAntsx=meatAnts;
        setLayout(null);
        setVisible(true);
    }

    @Override
    public String toString() {
        return "GridCanvas{" +
                "gridWidth=" + gridWidthx +
                ", gridHeight=" + gridHeightx +
                ", meatAnts=" + meatAntsx +
                ", plantAnts=" + plantAntsx +
                '}';
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        final int size = 8;
        Grid grid = new Grid(gridWidthx, gridHeightx,meatAntsx,plantAntsx);
        int x=0, y=0;
        Cell[][] cells = grid.getCells();
        for(x=0;x <gridWidthx; x++){
            for(y=0;y <gridHeightx; y++){
                if(cells[x][y].isWall())
                    g.fillRect(x*size,y*size,size,size);
                else
                    g.drawRect(x*size,y*size,size-1,size-1);
            }

        }

    }
}
