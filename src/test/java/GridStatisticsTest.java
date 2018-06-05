import Logic.Grid;
import org.junit.Assert;
import org.junit.Test;
import gui.GridCanvas;

public class GridStatisticsTest {


    @Test
    public void statisticsTest(){
        GridCanvas gridCanvas = new GridCanvas(50,50,50,50);
        Grid grid = new Grid(50,50,50,50);

        Assert.assertEquals(Integer.parseInt(gridCanvas.numberOfDeadPlants.getText().toString()), grid.getNumberOfDeadPlants());
        Assert.assertEquals(Integer.parseInt(gridCanvas.numberOfDeadMeat.getText().toString()), grid.getNumberOfDeadMeat());
        Assert.assertEquals(Integer.parseInt(gridCanvas.numberOfLivePlants.getText().toString()), grid.getNumberOfPlantEatingAnts());
        Assert.assertEquals(Integer.parseInt(gridCanvas.numberOfLiveMeat.getText().toString()), grid.getNumberOfMeatEatingAnts());
        Assert.assertEquals(Integer.parseInt(gridCanvas.numberOfBornPlants.getText().toString()), grid.getNumberOfBornPlants());
        Assert.assertEquals(Integer.parseInt(gridCanvas.numberOfBornMeat.getText().toString()), grid.getNumberOfBornMeat());

    }
}
