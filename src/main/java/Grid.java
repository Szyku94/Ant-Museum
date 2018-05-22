import java.util.List;

public class Grid {
    private int width;
    private int height;
    private List<Ant> ants;
    private Cell [][] cells;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;

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
    }
}
