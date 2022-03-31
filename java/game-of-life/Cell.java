public class Cell {
    private final boolean isAlive;

    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public String toString() {
        return isAlive ? "x" : ".";
    }
}
