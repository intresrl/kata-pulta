public class Cell {
    private boolean isAlive;

    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    @Override
    public String toString() {
        return isAlive ? "x" : ".";
    }
}
