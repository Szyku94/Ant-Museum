import gui.GridCanvas;
import gui.StartCanvas;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;

public class StartTests {


    @Test
    public void gridCanvasConstructor(){
        GridCanvas gridCanvas = new GridCanvas(50,50,50,50);
        Assert.assertEquals(50, gridCanvas.getGridHeightx());
        Assert.assertEquals(50, gridCanvas.getGridWidthx());
    }

    @Test
    public void creatingClassCanvas() {

        StartCanvas testerCanvas = new StartCanvas();
        Assert.assertNotNull(testerCanvas);

    }

    @Test
    public void textFieldValue() {
        StartCanvas testerCanvas = new StartCanvas();
        testerCanvas.getCountOfMeatAnts().setText("2");
        Assert.assertEquals("2",testerCanvas.getCountOfMeatAnts().getText());
        testerCanvas.getCountOfPlantAnts().setText("2");
        Assert.assertEquals("2",testerCanvas.getCountOfPlantAnts().getText());
    }

    @Test
    public void creatingClassStart() {
        Start testerStart = new Start();
        Assert.assertNotNull(testerStart);
    }

    @Test
    public void buttonClick(){
        StartCanvas testerCanvas = new StartCanvas(); // MyClass is tested


        testerCanvas.getCountOfMeatAnts().setText("2");
        testerCanvas.getCountOfPlantAnts().setText("2");
        testerCanvas.getGridHeight().setText("2");
        testerCanvas.getGridWidth().setText("2");

        Assert.assertEquals(2, Integer.parseInt(testerCanvas.getCountOfMeatAnts().getText()));
        Assert.assertEquals(2, Integer.parseInt(testerCanvas.getCountOfPlantAnts().getText()));
        Assert.assertEquals(2, Integer.parseInt(testerCanvas.getGridHeight().getText()));
        Assert.assertEquals(2, Integer.parseInt(testerCanvas.getGridWidth().getText()));
    }


}