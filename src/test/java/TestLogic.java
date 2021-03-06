import Logic.Ant;
import Logic.Grid;
import Logic.MeatEatingAnt;
import Logic.PlantEatingAnt;

public class TestLogic {
    public static void main(String[] args) {
        TestLogic testLogic = new TestLogic();
        testLogic.testGrid();
        testLogic.testAnt();
    }
    public void testGrid()
    {
        Grid grid = new Grid(40,50,30,120);
        assert (grid!=null);
        assert (grid.getHeight()==50);
        assert (grid.getWidth()==40);
        assert (grid.getNumberOfPlantEatingAnts()==120);
        assert (grid.getNumberOfMeatEatingAnts()==30);
        assert (grid.getAnts()!=null);
        assert (!grid.getAnts().isEmpty());
        for(int i = 0; i<1000;i++)
        {
            assert (grid.getNumberOfMeatEatingAnts()>=0);
            assert (grid.getNumberOfPlantEatingAnts()>=0);
            grid.nextTick();
            for(Ant ant:grid.getAnts())
            {
                int x=ant.getX();
                int y=ant.getY();
                assert (ant.getX()>=0);
                assert (ant.getY()>=0);
                assert (ant.getX()<grid.getWidth());
                assert (ant.getY()<grid.getHeight());
                for(Ant ant2:grid.getAnts())
                {
                    if(ant2 instanceof MeatEatingAnt&&ant instanceof PlantEatingAnt&&ant.getY()==ant2.getY()&&ant.getX()==ant2.getX())
                    {
                        assert(!ant.isAlive());
                    }
                }
                if(ant.isAlive())
                {
                    assert ((x==ant.getX()&&y==ant.getY())^(x==ant.getX()+1&&y==ant.getY())^(x==ant.getX()&&y==ant.getY()+1)^
                            (x==ant.getX()-1&&y==ant.getY())^(x==ant.getX()&&y==ant.getY()-1));
                }
            }


        }
    }
    public void testAnt()
    {
        Ant ant1 = new MeatEatingAnt(20,15);
        Ant ant2 = new PlantEatingAnt(20,15);
        assert (ant1.getX()==20);
        assert (ant1.getY()==15);
        assert (ant2.getX()==20);
        assert (ant2.getY()==15);
        ant1.die();
        assert (!ant1.isAlive());
        ant1.move(1,1);
        assert (ant1.getX()==21);
        assert (ant1.getY()==16);
    }
}
