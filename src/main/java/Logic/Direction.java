package Logic;

import java.util.Random;

public enum Direction {
    UP,DOWN,LEFT,RIGHT;
    public static Direction getRandomDirection()
    {
        Random random = new Random();
        switch (random.nextInt(4))
        {
            case 0:
                return UP;
            case 1:
                return DOWN;
            case 2:
                return LEFT;
            case 3:
                return RIGHT;
            default:
                return UP;
        }
    }
    public static Direction turnLeft(Direction direction)
    {
        switch (direction)
        {
            case UP:
                return LEFT;
            case DOWN:
                return RIGHT;
            case LEFT:
                return DOWN;
            case RIGHT:
                return UP;
            default:
                return UP;
        }
    }
    public static Direction turnRight(Direction direction)
    {
        switch (direction)
        {
            case UP:
                return RIGHT;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
            case RIGHT:
                return DOWN;
            default:
                return UP;
        }
    }
    public static Direction turnAround(Direction direction)
    {
        switch (direction)
        {
            case UP:
                return DOWN;
            case DOWN:
                return UP;
            case LEFT:
                return RIGHT;
            case RIGHT:
                return LEFT;
            default:
                return UP;
        }
    }
}
