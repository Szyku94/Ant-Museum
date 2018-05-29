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
        MapGenerator mapGenerator = new MapGenerator();
        cells=mapGenerator.generateMap();
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
        for (Ant ant : ants) {
            a:
            for(int i=0; i<10; i++)
            {
                switch (ant.newDirection()) {
                    case UP:
                        if (ant.getY() > 0 && !cells[ant.getX()][ant.getY() - 1].isWall()) {
                            if (!ant.move(0, -1)) {
                                deadAnts.add(ant);
                                break a;
                            }
                        }
                        break;
                    case DOWN:
                        if (ant.getY() < height - 1 && !cells[ant.getX()][ant.getY() + 1].isWall()) {
                            if (!ant.move(0, 1)) {
                                deadAnts.add(ant);
                                break a;
                            }
                        }
                        break;
                    case LEFT:
                        if (ant.getX() > 0 && !cells[ant.getX() - 1][ant.getY()].isWall()) {
                            if (!ant.move(-1, 0)) {
                                deadAnts.add(ant);
                                break a;
                            }
                        }
                        break;
                    case RIGHT:
                        if (ant.getX() < width - 1 && !cells[ant.getX() + 1][ant.getY()].isWall()) {
                            if (!ant.move(1, 0)) {
                                deadAnts.add(ant);
                                break a;
                            }
                        }
                        break;
                }
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
            if(ant instanceof PlantEatingAnt)
            {
                for (Ant ant2: ants)
                {
                    if(ant2 instanceof MeatEatingAnt)
                    {
                        if(ant.getX()==ant2.getX()&&ant.getY()==ant2.getY())
                        {
                            ((MeatEatingAnt) ant2).feed();
                            ant.die();
                            if(!deadAnts.contains(ant)) {
                                deadAnts.add(ant);
                            }
                            break;
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

    public int getNumberOfMeatEatingAnts() {
        return numberOfMeatEatingAnts;
    }

    public int getNumberOfPlantEatingAnts() {
        return numberOfPlantEatingAnts;
    }
    private class MapGenerator
    {
        float chanceToStartAlive = 0.4f;
        int deathLimit = 3;
        int birthLimit = 5;
        int numberOfSteps=2;

        public Cell[][] initialiseMap(Cell[][] map){
            Random random = new Random();
            for(int x=0; x<width; x++){
                for(int y=0; y<height; y++){
                    map[x][y]=new Cell(false);
                    if(random.nextInt() < chanceToStartAlive){
                        map[x][y].setWall(true);
                    }
                }
            }
            return map;
        }
        public int countAliveNeighbours(Cell[][] map, int x, int y){
            int count = 0;
            for(int i=-1; i<2; i++){
                for(int j=-1; j<2; j++){
                    int neighbour_x = x+i;
                    int neighbour_y = y+j;
                    if(i == 0 && j == 0){
                    }
                    else if(neighbour_x < 0 || neighbour_y < 0 || neighbour_x >= map.length || neighbour_y >= map[0].length){
                        count = count + 1;
                    }
                    else if(map[neighbour_x][neighbour_y].isWall()){
                        count = count + 1;
                    }
                }
            }
            return count;
        }
        public Cell[][] doSimulationStep(Cell[][] oldMap){
            Cell[][] newMap = new Cell[width][height];

            for(int x=0; x<oldMap.length; x++){
                for(int y=0; y<oldMap[0].length; y++){
                    newMap[x][y]=new Cell(false);
                    int nbs = countAliveNeighbours(oldMap, x, y);
                    if(oldMap[x][y].isWall()){
                        if(nbs < deathLimit){
                            newMap[x][y].setWall(false);
                        }
                        else{
                            newMap[x][y].setWall(true);
                        }
                    }
                    else{
                        if(nbs > birthLimit){
                            newMap[x][y].setWall(true);
                        }
                        else{
                            newMap[x][y].setWall(false);
                        }
                    }
                }
            }
            return newMap;
        }
        public Cell[][] generateMap(){
            Cell[][] map = new Cell[width][height];
            map = initialiseMap(map);
            for(int i=0; i<numberOfSteps; i++){
                map = doSimulationStep(map);
            }
            return map;
        }
    }
}
