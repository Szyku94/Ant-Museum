public class Cell {
    private boolean wall;

    public boolean isWall() {
        return wall;
    }

    public void setWall(boolean wall) {
        this.wall = wall;
    }

    public Cell(boolean wall) {

        this.wall = wall;
    }
}
