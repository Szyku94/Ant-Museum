package Logic;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Grid {
    private int width;
    private int height;
    private List<Ant> ants;
    private List<Ant> deadAnts;
    private Cell [][] cells;
    private int numberOfMeatEatingAnts;
    private int numberOfPlantEatingAnts;
    private int antLimit;
    private Random random;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        generate();
    }

    public Grid(int width, int height, int numberOfMeatEatingAnts, int numberOfPlantEatingAnts) {
        this.width = width;
        this.height = height;
        this.numberOfMeatEatingAnts = numberOfMeatEatingAnts;
        this.numberOfPlantEatingAnts = numberOfPlantEatingAnts;
        antLimit=numberOfMeatEatingAnts+numberOfPlantEatingAnts;
        generate();
    }

    private void generate()
    {
        random = new Random();
        cells=new Cell[width][height];
        for(int i = 0; i <width; i++)
        {
            for(int j = 0; j<height;j++)
            {
                cells[i][j]=new Cell(false);
            }
        }
        ants=new LinkedList<Ant>();
        int antX;
        int antY;
        for(int i = 0; i< numberOfMeatEatingAnts; i++)
        {
            antX=random.nextInt(width);
            antY=random.nextInt(height);
            while (true)
            {
                if(!cells[antX][antY].isWall())
                {
                    ants.add(new MeatEatingAnt(antX,antY));
                    break;
                }
                antX=random.nextInt(width);
                antY=random.nextInt(height);
            }
        }
        for(int i = 0; i< numberOfPlantEatingAnts; i++)
        {
            antX=random.nextInt(width);
            antY=random.nextInt(height);
            while (true)
            {
                if(!cells[antX][antY].isWall())
                {
                    ants.add(new PlantEatingAnt(antX,antY));
                    break;
                }
                antX=random.nextInt(width);
                antY=random.nextInt(height);
            }
        }
        deadAnts = new LinkedList<Ant>();
    }
    public void nextTick()
    {
        for (Ant ant:ants)
        {
            switch (ant.newDirection())
            {
                case UP:
                    if(ant.getY()>0&&!cells[ant.getX()][ant.getY()-1].isWall())
                    {
                        if(!ant.move(0,-1))
                        {
                            deadAnts.add(ant);
                        }
                    }
                    else
                    {
                        if(!ant.move(0,0))
                        {
                            deadAnts.add(ant);
                        }
                    }
                    break;
                case DOWN:
                    if(ant.getY()<height-1&&!cells[ant.getX()][ant.getY()+1].isWall())
                    {
                        if(!ant.move(0,1))
                        {
                            deadAnts.add(ant);
                        }
                    }
                    else
                    {
                        if(!ant.move(0,0))
                        {
                            deadAnts.add(ant);
                        }
                    }
                    break;
                case LEFT:
                    if(ant.getX()>0&&!cells[ant.getX()-1][ant.getY()].isWall())
                    {
                        if(!ant.move(-1,0))
                        {
                            deadAnts.add(ant);
                        }
                    }
                    else
                    {
                        if(!ant.move(0,0))
                        {
                            deadAnts.add(ant);
                        }
                    }
                    break;
                case RIGHT:
                    if(ant.getX()<width-1&&!cells[ant.getX()+1][ant.getY()].isWall())
                    {
                        if(!ant.move(1, 0))
                        {
                            deadAnts.add(ant);
                        }
                    }
                    else
                    {
                        if(!ant.move(0,0))
                        {
                            deadAnts.add(ant);
                        }
                    }
                    break;
            }
        }
        checkForCollision();
        clearDead();
        if(numberOfMeatEatingAnts+numberOfPlantEatingAnts<antLimit)
        {
            spawnNewAnts();
        }
    }
    private void clearDead()
    {
        for (Ant ant:deadAnts)
        {
            if(ant instanceof MeatEatingAnt)
            {
                numberOfMeatEatingAnts--;
            }
            else
            {
                numberOfPlantEatingAnts--;
            }
            ants.remove(ant);
        }
        deadAnts.clear();
    }
    private void spawnNewAnts()
    {
        for(int i =numberOfMeatEatingAnts+numberOfPlantEatingAnts;i<antLimit;i++)
        {
            spawnAnt();
        }
    }
    private void spawnAnt()
    {
        int antX=random.nextInt(width);
        int antY=random.nextInt(height);
        while (true)
        {
            if(!cells[antX][antY].isWall())
            {
                if(random.nextInt(3)<2)
                {
                    ants.add(new PlantEatingAnt(antX,antY));
                    numberOfPlantEatingAnts++;
                }
                else
                {
                    ants.add(new MeatEatingAnt(antX,antY));
                    numberOfMeatEatingAnts++;
                }
                break;
            }
            antX=random.nextInt(width);
            antY=random.nextInt(height);
        }
    }
    private void checkForCollision()
    {
        for (Ant ant: ants)
        {
            if(ant instanceof MeatEatingAnt)
            {
                for (Ant ant2: ants)
                {
                    if(ant2 instanceof PlantEatingAnt)
                    {
                        if(ant.getX()==ant2.getX()&&ant.getY()==ant2.getY())
                        {
                            ((MeatEatingAnt) ant).feed();
                            ant2.die();
                            deadAnts.add(ant2);
                        }
                    }
                }
            }
        }
    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Ant> getAnts() {
        return ants;
    }

    public Cell[][] getCells() {
        return cells;
    }
}
