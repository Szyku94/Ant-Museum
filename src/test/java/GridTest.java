import Logic.Ant;
import Logic.Grid;
import Logic.PlantEatingAnt;

public class GridTest {
    public static void main(String[] args) {
        Grid grid = new Grid(50,50,30,120);
        boolean quit=false;
        while (!quit) {
            for (int i = 0; i < grid.getWidth(); i++) {
                for (int j = 0; j < grid.getHeight(); j++) {
                    if (grid.getCells()[i][j].isWall()) {
                        System.out.print("##");
                    } else {
                        Ant x = null;
                        for (Ant ant : grid.getAnts()) {
                            if (ant.getX() == j && ant.getY() == i) {
                                x = ant;
                                break;
                            }
                        }
                        if (x!=null) {
                            System.out.print(x.getLifetime());
                            if (x instanceof PlantEatingAnt) {
                                System.out.print("P");
                            } else {
                                System.out.print("M");
                            }
                        } else {
                            System.out.print("__");
                        }
                    }
                }
                System.out.println();
            }
            System.out.println(grid.getNumberOfMeatEatingAnts()+"      "+grid.getNumberOfPlantEatingAnts());
            for(int i =0;i<1;i++)
            grid.nextTick();
            try{
                if(System.in.read()=='0')
                {
                    quit=true;
                }
            }
            catch (Exception e)
            {
                quit=true;
            }
        }
    }
}
