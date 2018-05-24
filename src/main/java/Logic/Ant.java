package Logic;

import java.util.Random;

public abstract class Ant {
    private int x;
    private int y;
    private int pMvForv;
    private int pMvLeft;
    private int pMvRight;
    private int pMvBack;
    protected int lifetime;
    private boolean alive;
    private Direction direction;
    public Direction newDirection()
    {
        Random random = new Random();
        int rnd = random.nextInt(100);
        if(rnd<pMvLeft)
        {
            direction=Direction.turnLeft(direction);
        }
        else if(rnd<pMvLeft+pMvBack)
        {
            direction=Direction.turnAround(direction);
        }
        else if(rnd<pMvLeft+pMvBack+pMvRight)
        {
            direction=Direction.turnRight(direction);
        }
        return direction;
    }
    public boolean move(int x, int y)
    {
        lifetime--;
        if(lifetime<=0)
        {
            die();
            return false;
        }
        this.x+=x;
        this.y+=y;
        return true;

    }
    public void die()
    {
        alive=false;
    }
    public Ant(int x, int y) {
        this.x = x;
        this.y = y;
        direction = Direction.getRandomDirection();
        pMvForv=40;
        pMvLeft=25;
        pMvRight=25;
        pMvBack=10;
        lifetime=9;
        alive=true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLifetime() {
        return lifetime;
    }
}
