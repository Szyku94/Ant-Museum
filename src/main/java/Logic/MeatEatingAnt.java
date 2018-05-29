package Logic;

public class MeatEatingAnt extends Ant {
    public MeatEatingAnt(int x, int y) {
        super(x, y);
    }
    public void feed()
    {
        lifetime+=5;
    }

    @Override
    public boolean move(int x, int y) {
        lifetime--;
        return super.move(x, y);
    }
}
