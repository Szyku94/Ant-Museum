package Logic;

public class MeatEatingAnt extends Ant {
    public MeatEatingAnt(int x, int y) {
        super(x, y);
    }
    public void feed()
    {
        lifetime+=5;
    }
}
