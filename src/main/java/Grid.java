import java.util.List;
import java.util.Random;

public class Grid {
    private int width;
    private int height;
    private List<Ant> ants;
    private Cell [][] cells;
    private int numberOfMeatEatingAnts;
    private int numberOfPlantEatingAnts;

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
        generate();
    }

    private void generate()
    {
        cells=new Cell[width][height];
        for(int i = 0; i <=width; i++)
        {
            for(int j = 0; j<=height;j++)
            {
                cells[i][j]=new Cell(false);
            }
        }
        Random random = new Random();
        for(int i = 0; i< numberOfMeatEatingAnts; i++)
        {
            ants.add(new MeatEatingAnt(random.nextInt(width),random.nextInt(height)));
        }
        for(int i = 0; i< numberOfPlantEatingAnts; i++)
        {
            ants.add(new PlantEatingAnt(random.nextInt(width),random.nextInt(height)));
        }
    }
}
