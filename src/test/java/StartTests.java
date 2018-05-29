import gui.GridCanvas;
import gui.StartCanvas;
import org.junit.Assert;
import org.junit.Test;
public class StartTests {

    StartCanvas testerCanvas = new StartCanvas(); // MyClass is tested
    GridCanvas gridCanvas = new GridCanvas(50,50,50,50);
    Start testerStart = new Start();

    @Test
    public void gridCanvasConstructor(){
        Assert.assertEquals(50, gridCanvas.getGridHeightx());
        Assert.assertEquals(50, gridCanvas.getGridWidthx());
    }

    @Test
    public void creatingClassCanvas() {

        Assert.assertNotNull(testerCanvas);

    }

    @Test
    public void textFieldValue() {
        testerCanvas.getCountOfMeatAnts().setText("2");
        Assert.assertEquals("2",testerCanvas.getCountOfMeatAnts().getText());
        testerCanvas.getCountOfPlantAnts().setText("2");
        Assert.assertEquals("2",testerCanvas.getCountOfPlantAnts().getText());
    }

    @Test
    public void creatingClassStart() {

        Assert.assertNotNull(testerStart);
    }

    @Test
    public void butonClick(){
        testerCanvas.getCountOfMeatAnts().setText("2");
        testerCanvas.getCountOfPlantAnts().setText("2");
        testerCanvas.getGridHeight().setText("2");
        testerCanvas.getGridWidth().setText("2");
        Assert.assertEquals(0, testerCanvas.getMeatAnts());
        Assert.assertEquals(0, testerCanvas.getPlantsAnts());
        Assert.assertEquals(0, testerCanvas.getGridHeightValue());
        Assert.assertEquals(0, testerCanvas.getGridWidthValue());
    }


}